package top_interviews_150_study

fun main() {
    merge(nums1 = intArrayOf(1, 2, 3, 0, 0, 0), m = 3, nums2 = intArrayOf(2, 5, 6), n = 3)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    val length = m + n

    for ((k, i) in (m until length).withIndex()) {
        nums1[i] = nums2[k]
    }

    nums1.sort()
    nums1.forEach { println(it) }

}