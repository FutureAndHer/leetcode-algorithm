package org.example.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到二叉树中和为某一值的路径
 *
 * @className: FindPathInBinaryTree
 * @author: Max Solider
 * @date: 2023-07-03 21:36
 */
public class FindPathInBinaryTree {

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode node, int target) {
        if (node == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findPath(node, target, new LinkedList<Integer>(), result);
        return result;
    }

    public static void findPath(TreeNode node, int target, LinkedList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (node == null) {
            return;
        }
        int left = target - node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && left == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(path);
            paths.add(list);
            path.removeLast();
            return;
        }
        findPath(node.left, left, path, paths);
        findPath(node.right, left, path, paths);
        path.removeLast();
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        ArrayList<ArrayList<Integer>> result = findPath(node1, 22);
        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
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
