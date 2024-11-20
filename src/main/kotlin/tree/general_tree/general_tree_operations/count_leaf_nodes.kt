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

    println("leafCount: ${countLeafNodesDFS(root)}")
}

/**
 * start at root, for each child recursively calculate its depth.
 * depth of current = 1 + max depth of its children
 **/
fun countLeafNodesRecursively(root: TreeNode<String>?): Int {
    if (root == null) return 0

    if (root.children.isEmpty()) return 1

    var leafCounts = 0

    for (child in root.children) {
        leafCounts += countLeafNodesRecursively(child)
    }

    return leafCounts
}

/** use a queue to traverse the tree by level
 * at each level check if current child has no children -> leaf node
 * if so increment the leafCount
 * */
fun countLeafNodesBFS(root: TreeNode<String>?): Int {
    if (root == null) return 0

    val queue = ArrayDeque<TreeNode<String>>()
    queue.add(root)

    var leafCount = 0

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current.children.isEmpty()) {
            leafCount++
        } else {
            current.children.forEach { queue.add(it) }
        }
    }

    return leafCount
}

/** use stack to traverse the tree in depth-first order
 * */
fun countLeafNodesDFS(root: TreeNode<String>?): Int {
    if (root == null) return 0

    val stack = Stack<TreeNode<String>>()
    stack.push(root)

    var leafCount = 0

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        if (current.children.isEmpty()){
            leafCount++
        }else{
            current.children.forEach { stack.push(it) }
        }
    }

    return leafCount
}