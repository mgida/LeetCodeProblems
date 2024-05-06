package top_interviews_150_study

fun main() {
    removeElement(nums = intArrayOf(2, 1, 3, 4), `val` = 2).also {
        println("count= $it")
    }
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    //trigger the counter, index to be inserted
    /** solution by 2 pointers**/
    var k = 0

    for (i in 0 until nums.size) {
        if (nums[i] != `val`) {
            nums[k] = nums[i]
            k++
        }
    }

    /*
     var jump = 0
        for (i in 0..<nums.size) {
            if (nums[i] == `val`) {
                jump++
            } else {
                nums[i - jump] = nums[i]
            }
        }
        return nums.size - jump
     */


    nums.forEach { println(it) }
    return k
}

/** numbers afters k are not important...
 * trigger count for k when num not equal to val
 * assign the same array with k
 * another solution if it equals val assign it to -1, then sort desc, then filter not equal to -1
 * using two pointers (insert pointer)
 * */
