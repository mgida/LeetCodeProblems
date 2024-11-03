package linked_list.leetcode_problems


fun main() {

    val l1 = createLinkedListOf()
    val l2 = createLinkedListOf()

    addTwoNumbers(l1, l2).also {
        printLinkedList(it)
    }

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {


    /** first use dummy list to simplify building the new list
     * dummy will start with 0, and once we return the result use dummy.next to skip its value and
     * return the building list we've made*/

    val dummy = ListNode(0)
    var current = dummy
    var carry = 0 // will hold the extra sum


    /** we might have edge cases like one list is longer than the other, or there is a carry at the end
     * for the one of longer list -> treat the other one values as zeros
     * for carry at the end, create a new node for it
     * */

    var l1Node = l1
    var l2Node = l2

    while (l1Node != null || l2Node != null || carry != 0) {

        val x = l1Node?.`val` ?: 0
        val y = l2Node?.`val` ?: 0
        val sum = x + y + carry

        carry = sum / 10
        val currentDigit = sum % 10

        val newNode = ListNode(currentDigit)

        /**update pointers*/

        current.next = newNode
        current = current.next!!

        l1Node = l1Node?.next
        l2Node = l2Node?.next

    }

    return dummy.next
}

