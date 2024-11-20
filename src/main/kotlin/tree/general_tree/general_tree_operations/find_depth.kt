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
    val childF = TreeNode("F")
    childC.apply {
        addChild(childF)
        addChild(TreeNode("G"))
    }

    childF.addChild(TreeNode("H"))

    println("max depth: ${findDepthDFS(root)}")
}

/**
 * start at root, for each child recursively calculate its depth.
 * depth of current = 1 + max depth of its children
 **/
fun findDepthRecursively(root: TreeNode<String>?): Int {
    if (root == null) return 0

    var maxDepth = 0

    for (child in root.children) {
        maxDepth = maxOf(maxDepth, findDepthRecursively(child))
    }

    return maxDepth + 1
}

/** use a queue to traverse the tree by level
 * at each level, count nodes. process them and enqueue their children
 * increment depth for each level processed*/
fun findDepthBFS(root: TreeNode<String>?): Int {
    if (root == null) return 0

    val queue = ArrayDeque<TreeNode<String>>()
    queue.add(root)

    var maxDepth = 0

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        for (i in 0.rangeUntil(levelSize)) {
            val current = queue.removeFirst()
            current.children.forEach { queue.add(it) }
        }

        maxDepth++
    }

    return maxDepth
}

/** use stack to traverse the tree in depth-first order
 * keep track of current depth of the node being processed
 * update maximum depth whenever a deeper node is encountered
 * */
fun findDepthDFS(root: TreeNode<String>?): Int {
    if (root == null) return 0

    val stack = Stack<Pair<TreeNode<String>, Int>>()
    stack.push(Pair(root, 1))

    var maxDepth = 0

    while (stack.isNotEmpty()) {
        val (current, depth) = stack.pop()
        maxDepth = maxOf(maxDepth, depth)
        current.children.forEach { stack.push(Pair(it, depth + 1)) }
    }

    return maxDepth
}