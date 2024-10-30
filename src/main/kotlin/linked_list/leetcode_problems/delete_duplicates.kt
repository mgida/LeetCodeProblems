package linked_list.leetcode_problems


fun deleteDuplicates(head: ListNode?): ListNode? {

    var current = head

    while (current != null) {

        if (current.`val` == current.next?.`val`) {
            current.next = current.next?.next
        }
        current = current.next
    }

    return head
}


fun main() {
    val node1 = ListNode(1)
    val node11 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node11
    node11.next = node2
    node2.next = null


    printLinkedList(node1)

    deleteDuplicates(node1).also {

        printLinkedList(it)
    }
}

