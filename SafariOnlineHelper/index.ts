import axios from "axios";
import { APIResponse, Result } from "./models/APIResponse";
import { persistToFile, uriEncode } from "./utility";
import readLine from "readline";

// an example for amazon
// https://learning.oreilly.com/library/view/amazon-hacks/0596005423/ch03s10.html#amazonhks-CHP-3-SECT-10.2

(function () {
    const readline = readLine.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    readline.question('What topic you want to search? ', name => {
        readline.question('How many pages to load? ', pages => {
            console.log(`Hey there ${name} ${pages}!`);
            app(String(name).trim().toLocaleLowerCase(), parseInt(pages))
            readline.close();
        });
    })
})()

const app = async function (searchInput: string, pagesCount = 50) {
    if (!searchInput) return

    const booksContainer: Result[] = []
    let initApi = `https://learning.oreilly.com/api/v2/search/?query=${uriEncode(searchInput)}&source=user&sort=relevance&facet_json=true&json_facets=true&page=0&include_facets=true&include_practice_exams=true&orm-service=search-frontend`
    // let initApi = `https://learning.oreilly.com/api/v2/search/?query=data%20structure&extended_publisher_data=true&highlight=true&include_assessments=false&include_case_studies=true&include_courses=true&include_playlists=true&include_collections=true&include_notebooks=true&include_sandboxes=true&include_scenarios=true&is_academic_institution_account=false&source=user&sort=relevance&facet_json=true&json_facets=true&page=0&include_facets=true&include_practice_exams=true&orm-service=search-frontend`
    // let initApi = `https://learning.oreilly.com/api/v2/search/?query=data%20structure&extended_publisher_data=true&highlight=true&include_assessments=false&include_case_studies=true&include_courses=true&include_playlists=true&include_collections=true&include_notebooks=true&include_sandboxes=true&include_scenarios=true&is_academic_institution_account=false&source=user&formats=book&formats=article&formats=journal&sort=relevance&facet_json=true&json_facets=true&page=0&include_facets=true&include_practice_exams=true&orm-service=search-frontend`

    const fetchBooksPromise = function (api: string): Promise<{ books: Result[], next?: string }> {
        return new Promise(async (resolve, reject) => {
            const response: APIResponse = (await axios.get(api)).data
            resolve({
                books: response.results,
                next: response.next
            })
        })
    }

    // cannot parallel process, since the uppper is the input of the next promise
    while (pagesCount && initApi) {
        const { books, next } = await fetchBooksPromise(initApi)

        booksContainer.push(...books)

        // replace the initApi with next
        initApi = next
        pagesCount--
    }

    // get the result
    // sort reviews count by descending
    booksContainer.sort((x, y) => y.number_of_reviews - x.number_of_reviews)

    persistToFile(booksContainer, searchInput)

    const n = booksContainer.length
    const outputArr = []
    outputArr.push(`INPUT: ${searchInput}`)
    outputArr.push(`TOTAL BOOKS: ${n}`)

    for (let i = 0; i < n; i++) {
        const book = booksContainer[i]
        outputArr.push(`${i + 1}.  ${book?.number_of_reviews}  ${book?.title}`)
    }

    persistToFile(outputArr.join('\n'), `${searchInput}.filtered`, 'txt')
}


