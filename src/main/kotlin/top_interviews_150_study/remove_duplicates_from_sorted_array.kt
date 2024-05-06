package top_interviews_150_study

fun main() {
    removeDuplicates(intArrayOf(1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6)).also {
        println(it)
    }
}

fun removeDuplicates(nums: IntArray): Int {

    var k = nums[0]
    var jump = 1

    for (ele in nums) {
        if (ele != k) {
            k = ele
            nums[jump] = k
            jump++
        }
    }

    nums.forEach {
        println("item $it")
    }
    return jump

    /** use counter with value of zero.. compare array with counter with array with i if not same increase counter
     * and assign the value of array of i to array of counter.. return counter + 1 */

//    var count = 0
//
//    for (i in 1 until nums.size){
//        if (nums[count] != nums[i]){
//            count ++
//            nums[count] = nums[i]
//        }
//    }
//    return count + 1

    //OR


    //    var count = 1
//
//    for (i in 1 until nums.size){
//        if (nums[i] != nums[i-1]){
//
//            nums[count] = nums[i]
    //   count++
//        }
//    }
//    return count


}

/** two pointers*/