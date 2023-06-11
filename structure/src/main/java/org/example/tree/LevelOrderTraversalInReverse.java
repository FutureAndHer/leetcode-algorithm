package org.example.tree;

import org.example.queue.ArrayQueue;
import org.example.stack.LLStack;

/**
 * 逆向逐层输出树中的元素
 *
 * @className: LevelOrderTraversalInReverse
 * @author: Max Solider
 * @date: 2023-06-11 18:35
 */
public class LevelOrderTraversalInReverse {

    public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        ArrayQueue queue = new ArrayQueue(20);
        LLStack stack = new LLStack();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode)queue.deQueue();
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
            stack.push(String.valueOf(tmp.getData()));
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
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
        levelOrderTraversalInReverse(node1);
    }
}
