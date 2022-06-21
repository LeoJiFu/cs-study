import { persistToFile, uriEncode } from "./utility"

test('uriEncode', () => {
    expect(uriEncode(' ')).toBe('%20')
})

test('persistToFile', () => {
    const arr = ["test input", "1. sdfs sdfas", "2. sdfsaf sdfasf"]
    expect(persistToFile(arr.join('\n'), 'sdfsa.filtered')).toBeCalled
})