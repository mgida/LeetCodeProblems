package linked_list.leetcode_problems


fun createLinkedListOf(): ListNode {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(2)
    val n5 = ListNode(1)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    return n1
}