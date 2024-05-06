package top_interviews_150_study

fun main(){
removeDuplicates2(nums = intArrayOf(1,1,1,2,2,3)).also {
    println(".. $it")
}
}

fun removeDuplicates2(nums: IntArray): Int {

    var count = 0
    for (i in 1 until nums.size){
        if (nums[i] == nums[i-1] && nums[i]== nums[i+1]){
            count = i+1
            nums[count] = nums[i+2]
        }
    }
    return count
}