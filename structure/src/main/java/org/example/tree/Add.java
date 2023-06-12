package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 求二叉树所有结点之和
 *
 * @className: Add
 * @author: Max Solider
 * @date: 2023-06-12 22:39
 */
public class Add {

    public static int add(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.getData() + add(root.getLeft()) + add(root.getRight());
    }

    public static int addWithLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        ArrayQueue queue = new ArrayQueue(20);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) queue.deQueue();
            sum += tmp.getData();
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(add(node1));
    }
}
