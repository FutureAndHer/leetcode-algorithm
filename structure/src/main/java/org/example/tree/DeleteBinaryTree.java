package org.example.tree;

/**
 * 删除二叉树
 *
 * @className: DeleteBinaryTree
 * @author: Max Solider
 * @date: 2023-06-11 18:30
 */
public class DeleteBinaryTree {

    public static void deleteBinaryTree(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        deleteBinaryTree(treeNode.getLeft());
        deleteBinaryTree(treeNode.getRight());
        treeNode = null;
    }
}
