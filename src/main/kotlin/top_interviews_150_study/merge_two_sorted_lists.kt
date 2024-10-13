package top_interviews_150_study


fun main() {

    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)


    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)


    mergeTwoLists(list1 = l1, list2 = l2).also { head ->

        var current = head
        while (current != null) {
            print("res... ${current.`val`} -> ")
            current = current.next
        }
        println("null") // End of the list
    }
}


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    val dummyNode = ListNode(0)
    var tail = dummyNode

    var l1 = list1
    var l2 = list2


    while (l1 != null && l2 != null) {

        if (l1.`val` < l2.`val`) {

            tail.next = l1
            l1 = l1.next

        } else {
            tail.next = l2
            l2 = l2.next
        }

        tail = tail.next!!
    }

    if (l1 != null) {
        tail.next = l1
    }
    if (l2 != null) {
        tail.next = l2
    }

    return dummyNode.next
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}



