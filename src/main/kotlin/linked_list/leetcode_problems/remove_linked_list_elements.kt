package linked_list.leetcode_problems


fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    printLinkedList(n1)

    removeElements(head = n1, `val` = 3).also {
        println("after")
        printLinkedList(it)
    }
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {

    var current = head

    while (current != null && current.`val` == `val`) {
        current = current.next
    }

    val newHead = current
    while (current?.next != null) {
        if (current.next?.`val` == `val`) {
            current.next = current.next?.next
        } else {
            current = current.next
        }
    }

    return newHead
}