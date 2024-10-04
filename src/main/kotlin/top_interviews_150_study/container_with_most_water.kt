package top_interviews_150_study

fun main() {

    maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)).also {
        println(it)
    }
}


fun maxArea(height: IntArray): Int {

    /** using brute force approach */

//    var maxArea: Int
//    var res = 0

//    for (i in 0 until height.size) {
//
//        for (j in i + 1 until height.size) {
//
//            val currentAreaWidth = j - 1
//            val currentAreaHeight = minOf(height[i], height[j])
//
//            maxArea = currentAreaWidth * currentAreaHeight
//            res = maxOf(res, maxArea)
//        }
//    }


    /** using two pointers, benefit from the minHeight to decide the shifting of each pointer */
    var res = 0

    var leftP = 0
    var rightP = height.size - 1

    while (leftP < rightP) {
        val currentWidth = rightP - leftP
        val currentHeight = minOf(height[leftP], height[rightP])

        val currentMaxArea = currentWidth * currentHeight

        res = maxOf(res, currentMaxArea)


        if (height[leftP] < height[rightP]) {
            leftP++
        } else {
            rightP--
        }
    }

    return res
}
