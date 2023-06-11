package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 找出二叉树中同一层级结点数据之和最大的层
 *
 * @className: FindLevelWithMaxSum
 * @author: Max Solider
 * @date: 2023-06-11 22:07
 */
public class FindLevelWithMaxSum {

    public static int findLevelWithMaxSum(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLevel = 0;
        int maxSum = 0;
        int level = 0;
        int sum = 0;
        ArrayQueue queue = new ArrayQueue(20);
        queue.enQueue(root);
        queue.enQueue(null);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) queue.deQueue();
            // 遍历到null结点，说明已经遍历完一层，将当前层级的结点之和与前面最大值作对比，更新最大值和对应层级
            if (tmp == null) {
                if (maxSum < sum) {
                    maxLevel = level;
                    maxSum = sum;
                }
                if (!queue.isEmpty()) {
                    queue.enQueue(null);
                }
                sum = 0;
                level++;
            } else {
                sum += tmp.getData();
                queue.enQueue(tmp.getLeft());
                queue.enQueue(tmp.getRight());
            }
        }
        return maxLevel;
    }
}
