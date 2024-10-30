package linked_list.leetcode_problems

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null

}

fun printLinkedList(head: ListNode?) {
    var current = head

    while (current != null) {
        print("${current.`val`}")
        if (current.next != null) {
            print("->")
        }

        current = current.next
    }

    println()
}