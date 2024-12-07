package tree.binary_tree


fun main() {
    val preorder = listOf("A", "B", "D", "E", "C", "F", "G")
    val inorder = listOf("D", "B", "E", "A", "F", "C", "G")

    constructBinaryTreeFromInorderAndPreorder(preorder, inorder)
}

fun constructBinaryTreeFromInorderAndPreorder(
    preorder: List<String>,
    inorder: List<String>
): TreeNode<String>? {
    if (preorder.isEmpty() || inorder.isEmpty()) return null

    val rootValue = preorder[0]
    val root = TreeNode(rootValue)

    // Find the index of the root in the inorder traversal
    val rootIndexInInorder = inorder.indexOf(rootValue)

    // Split inorder into left and right subtrees
    val inorderLeft = inorder.subList(0, rootIndexInInorder)
    val inorderRight = inorder.subList(rootIndexInInorder + 1, inorder.size)

    /** Split preorder into left and right subtrees (excluding the root)
     * inorderLeft.Size is used to correctly partition the preorder traversal into left and right subtrees.
     * inorderRight doesn't determine the split boundary in preorder traversal since the right subtree comes after all the left subtree nodes in preorder.
     * */
    val preorderLeft = preorder.subList(1, 1 + inorderLeft.size)
    val preorderRight = preorder.subList(1 + inorderLeft.size, preorder.size)

    // Recursively construct the left and right subtrees
    root.left = constructBinaryTreeFromInorderAndPreorder(preorderLeft, inorderLeft)
    root.right = constructBinaryTreeFromInorderAndPreorder(preorderRight, inorderRight)

    return root
}

