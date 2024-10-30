package linked_list.leetcode_problems


fun main() {

    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)

    n1.next = n2
    n2.next = n3
    n3.next = n4

    printLinkedList(n1)

    reverseListRecursively(n1).also {
        println("After reversing")
        printLinkedList(it)
    }
}

fun reverseList(head: ListNode?): ListNode? {

    var previous: ListNode? = null // for reversing the reference of each node
    var current = head // begin the traversal

    while (current != null) {
        val next = current.next
        current.next = previous // each node next will pointer to the previous
        previous = current
        current = next
    }

    return previous //will be the new head
}

fun reverseListRecursively(head: ListNode?): ListNode? {

    //base case
    if (head?.next == null) return head

    //recursive call, reverse the remaining parts of the list.. reach the end of the list and maintain the tail as the new head

    val newHead = reverseListRecursively(head.next)

    //reverse the link, forward & backward

    head.next?.next = head
    //break the original link
    head.next = null

    return newHead

}