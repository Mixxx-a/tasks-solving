fun main() {
    val input = arrayListOf<String>("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupWordsByCommonLettersNaive(input))
}

fun groupWordsByCommonLettersNaive(input: List<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()
    val map = mutableMapOf<String, MutableList<String>>()

    for (word in input) {
        val sortedWord = word.toCharArray().sorted().joinToString()
        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)
    }

    for ((_, value) in map)
        result.add(value)
    return result
}