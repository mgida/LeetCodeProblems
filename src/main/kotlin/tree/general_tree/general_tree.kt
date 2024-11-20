package tree.general_tree

class TreeNode<T>(val value: T) {
     val children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(child: TreeNode<T>) {
        children.add(child)
    }
}