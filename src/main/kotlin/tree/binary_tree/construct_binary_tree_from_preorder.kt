package tree.binary_tree

import java.util.*


fun main() {
    val preorder = listOf("A", "B", "D", null, null, null, "C", "E", null, null, "F", null, null)
    constructBinaryTree(preorder)
}

fun constructBinaryTree(preorder: List<String?>): TreeNode<String>? {
    if (preorder.isEmpty()) return null

    // Stack to maintain the nodes we are currently working on
    val stack = ArrayDeque<TreeNode<String>>()

    // The root of the tree is always the first non-null value in preorder traversal
    val root = TreeNode(preorder[0]!!)
    stack.push(root) // Push the root onto the stack to start building the tree

    // Index to track the current position in the preorder list
    var index = 1

    // Iterate through the preorder list to construct the tree
    while (index < preorder.size) {
        val current = preorder[index] // Get the current value in the preorder list
        val node = stack.peek() // Peek at the top node in the stack (current parent)

        if (current != null) {
            // If the current value is not null, create a new node
            val newNode = TreeNode(current)

            // Attach the new node as the left child if it's missing
            // Otherwise, attach it as the right child
            if (node.left == null) {
                node.left = newNode
            } else {
                node.right = newNode
            }

            // Push the new node onto the stack for further processing
            stack.push(newNode)
        } else {
            // If the current value is null, it indicates no child at this position
            // We pop nodes from the stack until we find a node that has an empty slot
            while (stack.isNotEmpty() && (stack.peek().left != null && stack.peek().right != null)) {
                stack.pop()
            }
        }

        // Move to the next value in the preorder list
        index++
    }

    // Return the constructed tree's root
    return root
}


