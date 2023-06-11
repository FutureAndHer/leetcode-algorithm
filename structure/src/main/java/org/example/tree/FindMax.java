package org.example.tree;

/**
 * 查找二叉树中的最大元素
 *
 * @className: FindMax
 * @author: Max Solider
 * @date: 2023-06-11 15:23
 */
public class FindMax {

    public static BinaryTreeNode findMax(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode max = root;
        BinaryTreeNode leftMax = null;
        BinaryTreeNode rightMax = null;
        if (root.getLeft() != null) {
            leftMax = findMax(root.getLeft());
        }
        if (root.getRight() != null) {
            rightMax = findMax(root.getRight());
        }
        if (leftMax != null && max.getData() < leftMax.getData()) {
            max = leftMax;
        }
        if (rightMax != null && max.getData() < rightMax.getData()) {
            max = rightMax;
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(findMax(node1).getData());
    }
}
