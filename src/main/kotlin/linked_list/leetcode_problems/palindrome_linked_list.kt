package linked_list.leetcode_problems

fun main() {
    val n1 = createLinkedListOf()

    printLinkedList(n1)

    isPalindrome(n1).also {
        println("res $it")
    }
}

fun isPalindrome(head: ListNode?): Boolean {

    /** find the middle of the linkedList by using two pointers, slow & fast*/

    var slow = head
    var fast = head

    /** move fast by 2 steps and slow by one step until you reach the end of the linked-list,
     *  this way we find the middle*/

    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    /** reverse the second half of the list, it starts from slow.next
     * using slow.next will skip the middle node in case the list is odd,
     * and will point exactly before the second half if the list is even
     * handle both even and odd-sized lists smoothly
     * */

    var reversedSecondHalf = reverseSecondHalf(slow?.next)

    printLinkedList(reversedSecondHalf)

    /** compare the reversed list with the given one*/

    var firstHalf = head

    while (reversedSecondHalf != null){

        if (firstHalf?.`val` == reversedSecondHalf.`val`){

            firstHalf = firstHalf.next
            reversedSecondHalf = reversedSecondHalf.next

        }else{
            return false
        }
    }

    return true
}

fun isPalindromeUsingArray(head: ListNode?): Boolean {
    /** another solution is to save the values of each node inside an array,
     * then using two pointers from the start and end of the array, compare values
     * time is O(n)
     * memory is O(n) since we are using extra space
     * */

    var current = head
    val values = mutableListOf<Int>()
    var index = 0

    while (current != null) {
        values.add( current.`val`)
        index++
        current = current.next
    }

    var left = 0
    var right = values.size - 1


    while (left < right) {
        if (values[left] != values[right]) {
            return false
        } else {
            left++
            right--
        }
    }

    return true
}


fun reverseSecondHalf(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null){
        val next = current.next
        current.next = prev
        prev= current
        current = next
    }

    return prev
}


