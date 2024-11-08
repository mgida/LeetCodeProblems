package daily
fun main() {

    canSortArray(intArrayOf(8, 4, 2, 30, 15)).also {
        println("res $it")
    }
}

fun canSortArray(nums: IntArray): Boolean {

    var swapped: Boolean
    do {
        swapped = false
        for (i in 0 until nums.size - 1) {
            if (countSetBits(nums[i]) == countSetBits(nums[i + 1]) && nums[i] > nums[i + 1]) {
                val temp = nums[i]
                nums[i] = nums[i + 1]
                nums[i + 1] = temp
                swapped = true
            }
        }
    } while (swapped) // Repeat until no more swaps are made

    for (i in 0 until nums.size - 1) {
        if (nums[i] > nums[i + 1]) return false
    }
    return true
}

fun countSetBits(num: Int): Int {
    var count = 0
    var n = num
    while (n > 0) {
        count += n and 1
        n = n shr 1
    }
    return count
}







