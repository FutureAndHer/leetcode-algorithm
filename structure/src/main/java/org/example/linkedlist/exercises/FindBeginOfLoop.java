package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 找到链表中环的起点
 *
 * @className: FindBeginofLoop
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class FindBeginOfLoop {

    /**
     * 找到链表中环的起点
     *
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     * @param headNode
     * @return NormalListNode
     */
    static NormalListNode findBeginofLoop(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            System.out.println("There is no loop in the linked list.");
            return null;
        }
        // 判断是否存在环，找到首次相遇点
        NormalListNode slowPtr = headNode, fastPtr = headNode;
        boolean loopExists = false;
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (fastPtr == slowPtr) {
                loopExists = true;
                break;
            }
        }
        if (!loopExists) {
            System.out.println("There is no loop in the linked list.");
            return null;
        }
        System.out.println("There is a loop in the linked list. The meeting node's value is :" + slowPtr.getData());
        // 将slowPtr指向表头，然后两个指针按照相同速度向前移动，再次相遇点即环起点
        slowPtr = headNode;
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext();
        }
        System.out.println("There begin node of loop is :" + slowPtr.getData());
        return slowPtr;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        findBeginofLoop(headNode);
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
        node5.setNext(node5);
        return node1;
    }
}
