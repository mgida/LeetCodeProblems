package linked_list

data class Node<T>(
    var data: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next == null) "$data" else "$data -> ${next.toString()}"
    }
}


class LinkedList<T> {

    var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0


    private fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }


    fun push(value: T): LinkedList<T> {
        /**each time we are inserting to the first of the list*/

        head = Node(data = value, next = head)
        if (tail == null) tail = head
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }

        tail?.next = Node(data = value, next = null)
        tail = tail?.next
        size++
        return this
    }


    fun findNodeAt(index: Int): Node<T>? {
        /**traverse from the head to reach the Node*/

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }


    fun insertAfter(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val linkOfNewNode = afterNode.next // now it links to this one, cuz afterNode was linked to it

        val newNode = Node(data = value, next = linkOfNewNode)
        /**here we need to update the link of the afterNode since it's delegated to the new Node*/

        afterNode.next = newNode
        size++

        return newNode
    }

    /** remove the first of the list
     * check if list is not empty, decrease the size.. get the value at first.. update head to its next..
     * check again if list is empty, that could happen is head becomes null, if so update the tail as well to be null
     * return the value, if found or not
     * */
    fun pop(): T? {

        if (!isEmpty()) size--
        val value = head?.data
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return value
    }


    /**check edge cases first -> list is empty or contains only an element
     * if it's not that decrease size and use two pointers from head.. prev & current
     * */

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) pop() // means it's only containing one element and job could be delegated to pop function

        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.data
    }

    /** firstly find a Node, remove its next
     * handle edge cases like node.next equals the tail, in such a case tail needs to be updated to this Node*/
    fun removeAfter(node: Node<T>) : T?{

        val result = node.next?.data

        if (node.next == tail){
            tail = node
        }

        if (node.next != null){
            size--
        }

        node.next = node.next?.next

        return result
    }

}

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.push(3).push(2).push(1)
    println(linkedList)
    linkedList.append(4).append(5)
    println(linkedList)

    // val afterNode = linkedList.head?.next?.next

//    if (afterNode != null) {
//        linkedList.insertAfter(value = 33, afterNode = afterNode)
//    }

    val afterNode = linkedList.findNodeAt(2)
    if (afterNode != null) {
        linkedList.insertAfter(33, afterNode)
    }

    println("Before popping the list..")
    println(linkedList)

    val poppedValue = linkedList.pop()
    println("After popping the list..$linkedList")
    println("Popped value..$poppedValue")

    println("After removing last")
    linkedList.removeLast()
    println(linkedList)


    val afterNode33 = linkedList.findNodeAt(2)
    if (afterNode33 != null) {
      val removedValue =  linkedList.removeAfter(afterNode33)
        println("removedValue $removedValue")
    }
    println("After 33.. $linkedList")

}