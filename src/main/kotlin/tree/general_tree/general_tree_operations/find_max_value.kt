package tree.general_tree.general_tree_operations

import tree.general_tree.TreeNode
import java.util.ArrayDeque
import java.util.Stack

fun main() {
    val root = TreeNode(10)
    val childB = TreeNode(20)
    val childC = TreeNode(5)

    root.apply {
        addChild(childB)
        addChild(childC)
    }
    childB.apply {
        addChild(TreeNode(30))
        addChild(TreeNode(40))
    }
    childC.apply {
        addChild(TreeNode(15))
        addChild(TreeNode(25))
    }

    println("Size of multi-level tree: ${findMaxDFS(root)}")
}


/**Recursion*/
fun findMaxRecursively(root: TreeNode<Int>?): Int {

    if (root == null) return Int.MIN_VALUE

    var maxValue = root.value

    for (child in root.children) {
        maxValue = maxOf(maxValue, findMaxRecursively(child))
    }

    return maxValue
}

/**DFS*/
fun findMaxDFS(root: TreeNode<Int>?): Int {

    if (root == null) return Int.MIN_VALUE

    var maxValue = Int.MIN_VALUE

    val stack = Stack<TreeNode<Int>>()

    stack.push(root)

    while (stack.isNotEmpty()) {

        val current = stack.pop()
        maxValue = maxOf(maxValue, current.value)
        current.children.forEach { stack.push(it) }
    }

    return maxValue
}

/**BFS*/
fun findMaxBFS(root: TreeNode<Int>?): Int {

    if (root == null) return Int.MIN_VALUE

    var maxValue = Int.MIN_VALUE

    val queue = ArrayDeque<TreeNode<Int>>()

    queue.add(root)

    while (queue.isNotEmpty()) {

        val current = queue.removeFirst()
        maxValue = maxOf(maxValue, current.value)
        current.children.forEach { queue.add(it) }
    }

    return maxValue
}