package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 计算链表中环的长度
 *
 * @className: FindLoopLength
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class FindLoopLength {

    /**
     * 计算链表中环的长度
     *
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     * @param headNode
     * @return int
     */
    static int findLoopLength(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return 0;
        }
        NormalListNode slowPtr = headNode, fastPtr = headNode;
        boolean loopExists = false;
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                System.out.println("There is a loop in the linked list. The meeting node's value is :" + slowPtr.getData());
                loopExists = true;
                break;
            }
        }
        if (!loopExists) {
            System.out.println("There is no loop in the linked list.");
            return 0;
        }
        int loopLength = 1;
        slowPtr = slowPtr.getNext();
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.getNext();
            loopLength++;
        }
        System.out.println("The loop in the linked list has " + loopLength + " nodes");
        return loopLength;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        findLoopLength(headNode);
    }

    /**
     * 初始化链表
     *
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 10:44
     */
    static NormalListNode initList() {
        NormalListNode node1 = new NormalListNode(1);
        NormalListNode node2 = new NormalListNode(2);
        NormalListNode node3 = new NormalListNode(3);
        NormalListNode node4 = new NormalListNode(4);
        NormalListNode node5 = new NormalListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);
        return node1;
    }
}
