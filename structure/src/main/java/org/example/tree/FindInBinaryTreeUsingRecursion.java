package org.example.tree;

/**
 * 在二叉树中搜索某个元素
 *
 * @className: FindInBinaryTreeUsingRecursion
 * @author: Max Solider
 * @date: 2023-06-11 15:37
 */
public class FindInBinaryTreeUsingRecursion {

    public static BinaryTreeNode findInBinaryTreeUsingRecursion(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.getData() == k) {
            return root;
        }
        BinaryTreeNode result = findInBinaryTreeUsingRecursion(root.getLeft(), k);
        if (result != null) {
            return result;
        }
        result = findInBinaryTreeUsingRecursion(root.getRight(), k);
        if (result != null) {
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(findInBinaryTreeUsingRecursion(node1, 10));
        System.out.println(findInBinaryTreeUsingRecursion(node1, 5));
    }
}
