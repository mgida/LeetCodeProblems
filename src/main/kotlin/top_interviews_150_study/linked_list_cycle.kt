package top_interviews_150_study


fun main() {

//    val head = ListNode(1)
//    head.next = ListNode(2)
//    head.next?.next = ListNode(3)
//    head.next?.next?.next = ListNode(4)

    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2


    hasCycle(head).also {
        println("res $it")
    }
}

fun hasCycle(head: ListNode?): Boolean {

    /** use two pointers, slow and fast
     * slow shifts by one and fast shifts by two
     * while the fast and fast.next is not null.. iterate and shift
     * if two pointers reached, there's a cycle
     * **/

    var slow = head
    var fast = head

    while ((fast != null) && (fast.next != null)) {

        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) return true
    }

    return false
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}