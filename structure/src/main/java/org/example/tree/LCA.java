package org.example.tree;

/**
 * 查找二叉树中两个结点的最近公共祖先（LCA）
 *
 * @className: LCA
 * @author: Max Solider
 * @date: 2023-06-15 08:06
 */
public class LCA {

    public static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        BinaryTreeNode left = lca(root.getLeft(), node1, node2);
        BinaryTreeNode right = lca(root.getRight(), node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(lca(node1, node1, node3).getData());
        System.out.println(lca(node1, node2, node6).getData());
        System.out.println(lca(node1, node5, node6).getData());
        System.out.println(lca(node1, node4, node5).getData());
        System.out.println(lca(node1, node3, node6).getData());
    }
}
