fun main() {
    println(findIntersectionsNaive(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3)))
    println(findIntersectionsNaive(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3, 2)))
    println()

    println(findIntersectionsUsingHashSet(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3)))
    println(findIntersectionsUsingHashSet(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3, 2)))
}

fun findIntersectionsNaive(array1: IntArray, array2: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    val markedIntersectionArray2 = BooleanArray(array2.size)

    for (num1 in array1) {
        for (index2 in array2.indices) {
            if (num1 == array2[index2] && !markedIntersectionArray2[index2]) {
                result.add(num1);
                markedIntersectionArray2[index2] = true
            }
        }
    }
    return result
}

fun findIntersectionsUsingHashSet(array1: IntArray, array2: IntArray): List<Int> {
    val s1 = array1.toHashSet()
    val s2 = array2.toHashSet()
    val result = mutableListOf<Int>()

    for (el in s1) {
        if (s2.contains(el)) {
            val numberOfRepeats = minOf(array1.count { it == el }, array2.count { it == el })
            repeat(numberOfRepeats) { result.add(el) }
        }
    }
    return result
}