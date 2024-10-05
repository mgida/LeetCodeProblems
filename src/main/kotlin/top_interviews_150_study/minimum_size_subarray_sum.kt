package top_interviews_150_study

fun main() {
    minSubArrayLen(target = 7, nums = intArrayOf(2, 3, 1, 2, 4, 3)).also {
        println("res $it")
    }
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {

    /** using sliding window with two pointers, start the two pointers at the first index, calculate the total of the window, compare with the target
     * while the total is equal or greater than the target.. calculate the size of the window, get the min result, shift the right pointer and subtract it from total
     * note that, using while loop inside the for loop doesn't necessarily mean that is O(n2).. the while loop will only execute at specific times
     * */
    var lP = 0
    var total = 0
    var res = Int.MAX_VALUE

    for (rp in nums.indices) {
        total += nums[rp]

        while (total >= target) {
            val sizeOfWindow = (rp - lP) + 1
            res = minOf(res, sizeOfWindow)
            total -= nums[lP]
            lP++
        }
    }

    return if (res == Int.MAX_VALUE) 0 else res
}