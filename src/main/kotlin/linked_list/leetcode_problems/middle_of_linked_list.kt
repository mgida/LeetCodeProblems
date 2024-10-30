package linked_list.leetcode_problems

fun main(){
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

    middleNode(n1).also {
        println("Middle value is ${it?.`val`}")
       printLinkedList(it)
    }
}

fun middleNode(head: ListNode?): ListNode? {

    var slow : ListNode? = head
    var fast : ListNode? = head

    while (fast?.next != null){
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}