package org.example.tree;

/**
 * 镜像翻转二叉树
 *
 * @className: MirrorOfBinaryTree
 * @author: Max Solider
 * @date: 2023-06-12 23:04
 */
public class MirrorOfBinaryTree {

    public static void mirrorOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        mirrorOfBinaryTree(root.getLeft());
        mirrorOfBinaryTree(root.getRight());
        BinaryTreeNode tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println("先序：");
        BinaryTreeNode.preOrder(node1);
        System.out.println("翻转后先序：");
        mirrorOfBinaryTree(node1);
        BinaryTreeNode.preOrder(node1);
    }
}
