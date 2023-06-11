package org.example.tree;

/**
 * 求二叉树高度
 *
 * @className: HeightOfBinaryTree
 * @author: Max Solider
 * @date: 2023-06-11 19:00
 */
public class HeightOfBinaryTree {

    public static int heightOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.getLeft());
        int rightHeight = heightOfBinaryTree(root.getRight());
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(heightOfBinaryTree(node1));
    }
}
