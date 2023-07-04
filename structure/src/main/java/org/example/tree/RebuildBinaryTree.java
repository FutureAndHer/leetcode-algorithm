package org.example.tree;

import apple.laf.JRSUIUtils;

/**
 * 给定前序遍历和中序遍历结果，重建二叉树
 *
 * @className: RebuildBinaryTree
 * @author: Max Solider
 * @date: 2023-07-03 22:48
 */
public class RebuildBinaryTree {


    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vinOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode head = rebuildBinaryTree(preOrder, vinOrder);
        System.out.println(head.val);
    }

    public static int rootIndex = 0;

    // 先序遍历结果中的第一个元素是根结点
    // 中序遍历中，根结点两边的元素是左右子树
    private static TreeNode rebuildBinaryTree(int[] preOrder, int[] vinOrder) {
        return rebuild(preOrder, 0, vinOrder, 0, vinOrder.length - 1);
    }

    // 递归构建子树
    private static TreeNode rebuild(int[] preOrder, int rootIndex, int[] vinOrder, int vinStart, int vinEnd) {
        if (rootIndex >= preOrder.length || vinStart > vinEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int index = 0;
        for (int i = vinStart; i <= vinEnd; i++) {
            if (vinOrder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = rebuild(preOrder, rootIndex + 1, vinOrder, vinStart, index - 1);
        root.right = rebuild(preOrder, rootIndex + index - vinStart + 1, vinOrder, index + 1, vinEnd);
        return root;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
