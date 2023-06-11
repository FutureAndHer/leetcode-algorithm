package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 向二叉树中插入元素
 *
 * @className: InsertInBinaryTree
 * @author: Max Solider
 * @date: 2023-06-11 16:16
 */
public class InsertInBinaryTree {

    public static void insertInBinaryTree(BinaryTreeNode node, BinaryTreeNode root) {
        if (root == null || node == null) {
            return;
        }
        ArrayQueue queue = new ArrayQueue(20);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode)queue.deQueue();
            if (tmp.getLeft() == null) {
                tmp.setLeft(node);
                return;
            }
            if (tmp.getRight() == null) {
                tmp.setRight(node);
                return;
            }
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
        }
    }
}
