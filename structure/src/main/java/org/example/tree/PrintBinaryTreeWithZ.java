package org.example.tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字形顺序打印二叉树
 *
 * @className: PrintBinaryTreeWithZ
 * @author: Max Solider
 * @date: 2023-07-03 23:37
 */
public class PrintBinaryTreeWithZ {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        ArrayList<ArrayList<Integer>> result = printWithZ(node1);
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> printWithZ(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        boolean fromLeftToRight = true;
        stack1.push(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (fromLeftToRight) {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                while (!stack1.isEmpty()) {
                    TreeNode tmp = stack1.pop();
                    if (tmp.left != null) {
                        stack2.push(tmp.left);
                    }
                    if (tmp.right != null) {
                        stack2.push(tmp.right);
                    }
                    tmpList.add(tmp.val);
                }
                fromLeftToRight = false;
                result.add(tmpList);
            } else {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                while (!stack2.isEmpty()) {
                    TreeNode tmp = stack2.pop();
                    if (tmp.right != null) {
                        stack1.push(tmp.right);
                    }
                    if (tmp.left != null) {
                        stack1.push(tmp.left);
                    }
                    tmpList.add(tmp.val);
                }
                fromLeftToRight = true;
                result.add(tmpList);
            }
        }
        return result;
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
