package org.example.tree;

/**
 * 求二叉树直径
 *
 * @className: DiameterOfTree
 * @author: Max Solider
 * @date: 2023-06-11 19:49
 */
public class DiameterOfTree {

    private static int diameter = 0;
    public static int diameterOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfTree(root.getLeft());
        int right = diameterOfTree(root.getRight());
        if (left + right > diameter) {
            diameter = left + right;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(diameterOfTree(node1));
    }
}
