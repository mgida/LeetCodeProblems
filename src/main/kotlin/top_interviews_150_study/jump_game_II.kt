package top_interviews_150_study

import kotlin.math.max

fun main() {
    jump(intArrayOf(2, 3, 1, 1, 4)).also {
        println("min jump $it")
    }
}

fun jump(nums: IntArray): Int {
    var res = 0
    var l = 0
    var r = 0

    while (r < nums.size -1){

        var farthest = 0

        for (i in l..<r+1){
            farthest = max(farthest, i + nums[i])
        }

        l = r+1
        r = farthest
        res +=1

    }

    return res
}