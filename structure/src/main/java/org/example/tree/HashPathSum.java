package org.example.tree;

/**
 * 判断是否存在路径的数据和等于给定值
 *
 * @className: HashPathSum
 * @author: Max Solider
 * @date: 2023-06-12 22:34
 */
public class HashPathSum {

    public static boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null && sum != 0) {
            return false;
        }
        sum = sum - root.getData();
        if (sum == 0) {
            return true;
        }
        return hasPathSum(root.getLeft(), sum) || hasPathSum(root.getRight(), sum);
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(hasPathSum(node1, 10));
    }
}
