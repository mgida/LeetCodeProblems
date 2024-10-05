package top_interviews_150_study

fun main() {
    lengthOfLongestSubstring("pwwkew").also {
        println("res $it")
    }
}

fun lengthOfLongestSubstring(s: String): Int {


    /** using sliding window with two pointers starting from the beginning.. using Set to define the unique elements
     * while a char is repeated, remove it from the set, shift the left pointer.. otherwise add the char to the set
     * and calculate the max substring by comparing previous values with the current window size..
     * window size could be computed by rightP-leftP+1.. or use count on the set
     * */

    var l = 0
    var res = 0
    val mySet = hashSetOf<Char>()

    for (r in s.indices) {

        while (mySet.contains(s[r])) {
            mySet.remove(s[l])
            l++
        }

        mySet.add(s[r])
        res = maxOf(res, r - l + 1)// or mySet.count()
    }

    return res
}