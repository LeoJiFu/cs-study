import fs from "fs"
import { json } from "stream/consumers";

export const persistToFile = function (input, name, type = 'json') {
    try {
        fs.writeFileSync(`./data/${name}-${Date.now()}.${type}`, typeof (input) === 'string' ? input : JSON.stringify(input, null, 2), 'utf-8');
    } catch (error) {
        throw error
    }

}

export const uriEncode = function (input: string) {
    return encodeURI(String(input))
}