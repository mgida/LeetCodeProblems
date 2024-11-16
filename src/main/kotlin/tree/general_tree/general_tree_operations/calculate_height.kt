package tree.general_tree.general_tree_operations

import tree.general_tree.TreeNode

fun main() {

    val root = TreeNode("A")
    val child1 = TreeNode("B")
    val child2 = TreeNode("C")
    root.apply {
        addChild(child1)
        addChild(child2)
    }

    child1.addChild(TreeNode("D"))

    child2.apply {
        addChild(TreeNode("E"))
        addChild(TreeNode("F"))
    }
    calculateHeight(root).also {
        println("height of tree is $it")
    }
}

fun <T> calculateHeight(node: TreeNode<T>?): Int {
    /** start at the root, recursively calculate the height of each subTree
     * height = 1 + the max height of all child nodes
     * */

    if (node == null) return 0
    if (node.children.isEmpty()) return 1

    return 1 + node.children.maxOf {
        calculateHeight(it)
    }
}