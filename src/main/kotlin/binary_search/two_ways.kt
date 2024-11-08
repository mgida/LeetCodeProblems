package binary_search


fun main() {

    val arr = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15)
    val target = 7
    val result = binarySearchRecursive(arr, target, 0, arr.size - 1)

    if (result != -1) {
        println("Element found at index $result")
    } else {
        println("Element not found")
    }
}


fun binarySearchIterative(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {

        /**to avoid overflow ensuring that the addition operation does not exceed the integer limit*/
        val middle = left + (right - left) / 2


        when {
            arr[middle] == target -> return middle
            arr[middle] > target -> left = middle - 1
            else -> right = middle + 1
        }
    }
    return -1
}

fun binarySearchRecursive(arr: IntArray, target: Int, left: Int, right: Int): Int {

    /**base case*/
    if (left > right) return -1
    val mid = left + (right - left) / 2
    return when {
        arr[mid] == target -> mid
        arr[mid] < target -> binarySearchRecursive(arr, target, mid + 1, right)
        else -> binarySearchRecursive(arr, target, left, mid - 1)
    }
}