package org.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现二叉树先序、中序、后序遍历
 * 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 *
 * @className: PrintBinaryTree
 * @author: Max Solider
 * @date: 2023-07-05 23:52
 */
public class PrintBinaryTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        int[][] result = treeOrders(node1);
        if (result == null) {
            return;
        }
        for (int[] order : result) {
            for (int i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] treeOrders(TreeNode root) {
        // 1. 入参合法性校验
        if (root == null) {
            int[][] result = {{}, {}, {}};
            return result;
        }
        if (root.right == null && root.left == null) {
            int[][] result = {{root.val}, {root.val}, {root.val}};
            return result;
        }
        // 按先序、中序、后序遍历二叉树
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        preOrder(root, preOrder);
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrder(root, inOrder);
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        postOrder(root, postOrder);
        int[][] result = new int[3][preOrder.size()];
        for (int i = 0; i < preOrder.size(); i++) {
            result[0][i] = preOrder.get(i);
            result[1][i] = inOrder.get(i);
            result[2][i] = postOrder.get(i);
        }
        return result;
    }

    private static void preOrder(TreeNode root, ArrayList<Integer> integers) {
        // 先序遍历，输出顺序为 根结点、左子结点、右子节点
        // 递归构造先序序列
        if (root == null) {
            return;
        }
        integers.add(root.val);
        preOrder(root.left, integers);
        postOrder(root.right, integers);
    }

    private static void inOrder(TreeNode root, ArrayList<Integer> integers) {
        // 中序遍历，输出顺序为 左子结点、根结点、右子节点
        // 递归构造中序序列
        if (root == null) {
            return;
        }
        preOrder(root.left, integers);
        integers.add(root.val);
        postOrder(root.right, integers);
    }

    private static void postOrder(TreeNode root, ArrayList<Integer> integers) {
        // 后序遍历，输出顺序为 左子结点、右子节点、根结点
        // 递归构造中序序列
        if (root == null) {
            return;
        }
        preOrder(root.left, integers);
        postOrder(root.right, integers);
        integers.add(root.val);
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
