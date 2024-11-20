package tree.general_tree.general_tree_operations

import tree.general_tree.TreeNode
import java.util.*
import kotlin.collections.ArrayDeque


fun main() {
    val root = TreeNode("A")
    val childB = TreeNode("B")
    val childC = TreeNode("C")

    root.apply {
        addChild(childB)
        addChild(childC)
    }
    childB.apply {
        addChild(TreeNode("D"))
        addChild(TreeNode("E"))
    }
    childC.apply {
        addChild(TreeNode("F"))
        addChild(TreeNode("G"))
    }

    println("Size of multi-level tree: ${calculateSizeDFS(root)}")
}


/**Recursion Approach*/
fun <T> calculateSize(node: TreeNode<T>?): Int {
    if (node == null) return 0

    /** recursive case
     * size of node is 1 + sum (sized of all children)
     * */
    return 1 + node.children.sumOf { calculateSize(it) }
}


/**Iterative Approach using BFS
 * start with the root, add it to the queue
 * use a counter to keep track of all visited nodes
 * for each node dequeued : increment the counter, add all its children to the queue
 * return the counter*/
fun <T> calculateSizeBFS(root: TreeNode<T>?): Int {
    if (root == null) return 0

    var size = 0
    //   val queue: Queue<TreeNode<T>> = LinkedList()
    val queue: ArrayDeque<TreeNode<T>> = ArrayDeque()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        size++
        current.children.forEach {
            queue.add(it)
        }
    }
    return size
}


/**Iterative Approach using DFS
 * simulate the recursion stack using an explicit stack data structure
 * It follows a Last-In-First-Out (LIFO) approach, ensuring we visit nodes in a depth-first manner.
 * */
fun <T> calculateSizeDFS(root: TreeNode<T>?): Int {
    if (root == null) return 0

    var size = 0
    val stack: Stack<TreeNode<T>> = Stack()
    stack.add(root)

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        size++
        current.children.forEach {
            stack.add(it)
        }
    }
    return size
}

