package top_interviews_150_study

fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 9).also {
        for (i in it.indices)
            println("res: ${it[i]}")
    }
}

fun twoSum(numbers: IntArray, target: Int): IntArray {

    /** Since array is sorted, we could eliminate the values.. use two pointers for start & end of the array
     * calculate the current sum of pointers, determine to decrease or increase the pointer
     * target found, return the indices
     * */


    var firstP = 0
    var lastP = numbers.size - 1


    for (i in 0 until numbers.size) {

        val sum = numbers[firstP] + numbers[lastP]

        if (sum > target) {
            lastP--
        } else if (sum < target) {
            firstP++
        } else {
            return intArrayOf((firstP + 1), (lastP + 1))
        }

    }

    return intArrayOf()
}