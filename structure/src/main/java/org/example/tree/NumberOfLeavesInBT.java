package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 计算二叉树中叶子结点个数
 *
 * @className: NumberOfLeavesInBT
 * @author: Max Solider
 * @date: 2023-06-11 19:29
 */
public class NumberOfLeavesInBT {

    public static int numberOfLeavesInBT(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        ArrayQueue queue = new ArrayQueue(10);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) queue.deQueue();
            if (tmp.getLeft() == null && tmp.getRight() == null) {
                count ++;
            }
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
        }
        return count;
    }
}
