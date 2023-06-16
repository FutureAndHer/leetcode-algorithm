package org.example.tree;

import org.example.queue.ArrayQueue;
import org.example.stack.LLStack;
import sun.misc.Queue;

import java.util.Stack;


/**
 * zigzag遍历二叉树
 *
 * @className: ZigZagTraversal
 * @author: Max Solider
 * @date: 2023-06-15 21:18
 */
public class ZigZagTraversal {

    public static void zigZagTraversal(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return;
        }
        // 是否从左向右遍历
        boolean leftToRight = true;
        // 借助两个辅助栈 存储当前层 和 下一层的数据
        Stack currentLevel = new Stack();
        Stack nextLevel = new Stack();
        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) currentLevel.pop();
            System.out.println(tmp.getData());
            if (leftToRight) {
                if (tmp.getLeft() != null) {
                    nextLevel.push(tmp.getLeft());
                }
                if (tmp.getRight() != null) {
                    nextLevel.push(tmp.getRight());
                }
            } else {
                if (tmp.getRight() != null) {
                    nextLevel.push(tmp.getRight());
                }
                if (tmp.getLeft() != null) {
                    nextLevel.push(tmp.getLeft());
                }
            }
            // 当前层遍历完后，需要交换下一层和当前层
            if (currentLevel.isEmpty()) {
                leftToRight = leftToRight ? false : true;
                Stack tmpStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmpStack;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        zigZagTraversal(node1);
    }
}
