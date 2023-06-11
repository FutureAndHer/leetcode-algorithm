package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 查找二叉树中最深结点
 *
 * @className: DeepestNodeinBinaryTree
 * @author: Max Solider
 * @date: 2023-06-11 19:07
 */
public class DeepestNodeInBinaryTree {

    public static BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayQueue queue = new ArrayQueue(10);
        queue.enQueue(root);
        BinaryTreeNode result = root;
        while (!queue.isEmpty()) {
            result = (BinaryTreeNode)queue.deQueue();
            if (result.getLeft() != null) {
                queue.enQueue(result.getLeft());
            }
            if (result.getRight() != null) {
                queue.enQueue(result.getRight());
            }
        }

        return result;
    }
}
