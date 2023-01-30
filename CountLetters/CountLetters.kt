fun main() {
    val input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBB"
    println(codeStringNaive(input))
    println(codeStringNaive2(input))
}

fun codeStringNaive(input: String): String {
    var result = ""

    val inputIterator = input.iterator()
    var previousChar = inputIterator.nextChar()
    var counter = 1
    while (inputIterator.hasNext()) {
        val currentChar = inputIterator.nextChar()
        if (currentChar == previousChar) {
            counter++
            continue
        } else {
            if (counter == 1) {
                result += previousChar
            } else {
                result = result + previousChar + counter
            }
            previousChar = currentChar
            counter = 1
        }
    }
    if (counter == 1) {
        result += previousChar
    } else {
        result = result + previousChar + counter
    }

    return result
}

fun codeStringNaive2(input: String): String {
    var currentLetter = input[0]
    var result = ""
    var count = 1

    for (letter in input.substring(1)) {
        if (currentLetter == letter) {
            count++
        } else {
            if (count == 1) {
                result += currentLetter
            } else {
                result += "$currentLetter$count"
            }
            currentLetter = letter
            count = 1
        }
    }
    if (count == 1) {
        result += currentLetter
    } else {
        result += "$currentLetter$count"
    }

    return result
}