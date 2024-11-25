package tree.general_tree.general_tree_operations

import tree.general_tree.TreeNode
import java.util.*

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

    println("leafCount: ${findPathToNodeDFS(root, target = "H")}")
}


/**Recursive DFS*/
fun <T> findPathToNode(root: TreeNode<T>?, target: T): List<T> {

    if (root == null) return emptyList()
    if (root.value == target) return listOf(root.value)


    for (child in root.children) {
        val path = findPathToNode(root = child, target = target)

        if (path.isNotEmpty()) {
            return listOf(root.value) + path
        }

    }

    return emptyList()
}


/**Iterative DFS*/
fun <T> findPathToNodeDFS(root: TreeNode<T>?, target: T): List<T> {

    if (root == null) return emptyList()
    if (root.value == target) return listOf(root.value)

    val stack = Stack<Pair<TreeNode<T>, List<T>>>()
    stack.push(Pair(root, listOf(root.value)))

    while (stack.isNotEmpty()) {

        val (current, path) = stack.pop()

        if (current.value == target) {
            return path
        }

        for (child in current.children.reversed()) {
            stack.push(Pair(child, path + listOf(child.value)))
        }
    }

    return emptyList()
}

/**BFS*/
fun <T> findPathToNodeBFS(root: TreeNode<T>?, target: T): List<T> {

    if (root == null) return emptyList()

    val queue = ArrayDeque<Pair<TreeNode<T>, List<T>>>()
    queue.add(root to listOf(root.value))


    while (queue.isNotEmpty()) {

        val (current, path) = queue.remove()

        if (current.value == target) return path

        for (child in current.children){

            queue.add(child to (path + listOf(child.value)))

        }
    }

    return emptyList()
}










