package top_interviews_150_study

fun main() {
    longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)).also {
        println("res $it")
    }
}

/** put all elements from the array into a hash set, For each number check if it’s the start of a sequence
 * num - 1 is not in the set
 * count consecutive numbers by incrementing until the next number (num + 1) is not in the set.
 * return longest streak found
 ***/

fun longestConsecutive(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    val hashSet = hashSetOf<Int>()
    var longestStreak = 0

    for (num in nums) hashSet.add(num)

    for (num in hashSet) {

        val startPointFound = !hashSet.contains(num - 1)

        if (startPointFound) {

            var currentNumber = num
            var currentStreak = 1

            while (hashSet.contains(currentNumber + 1)) {
                currentNumber += 1
                currentStreak += 1
            }

            longestStreak = maxOf(longestStreak, currentStreak)
        }
    }

    return longestStreak
}