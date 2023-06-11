package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 二叉树
 *
 * @className: BinaryTreeNode
 * @author: Max Solider
 * @date: 2023-06-11 11:29
 */
public class BinaryTreeNode {

    private int data;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public int getData() {
        return data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历二叉树
     *
     * @param treeNode 二叉树
     */
    public static void preOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.getData());
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    /**
     * 中遍历二叉树
     *
     * @param treeNode 二叉树
     */
    public static void inOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeft());
        System.out.println(treeNode.getData());
        inOrder(treeNode.getRight());
    }

    /**
     * 后序遍历二叉树
     *
     * @param treeNode 二叉树
     */
    public static void postOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.println(treeNode.getData());
    }

    /**
     * 层次遍历二叉树
     *
     * @param treeNode 二叉树
     */
    public static void levelOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 借助队列实现
        ArrayQueue queue = new ArrayQueue(20);
        queue.enQueue(treeNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) queue.deQueue();
            System.out.println(tmp.getData());
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
        }
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
        preOrder(node1);
        System.out.println("================");
        System.out.println("中序：");
        inOrder(node1);
        System.out.println("================");
        System.out.println("后序：");
        postOrder(node1);
        System.out.println("================");
        System.out.println("层次遍历：");
        levelOrder(node1);
        System.out.println("================");
    }
}
