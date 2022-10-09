package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 判定链表中是否存在环
 *
 * @className: DoesLinkedListContainsLoop
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class DoesLinkedListContainsLoop {

    /**
     * 找到链表倒数第n个结点
     *
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 10:45
     */
    static boolean doesLinkedListContainsLoop(NormalListNode headNode) {
        if (headNode == null) {
            return false;
        }
        if (headNode.getNext() == null) {
            return false;
        }
        NormalListNode slowPtr = headNode, fastPtr = headNode;
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                System.out.println("There is a loop in the linked list.");
                return true;
            }
        }
        System.out.println("There is no loop in the linked list.");
        return false;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        doesLinkedListContainsLoop(headNode);
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
//        node5.setNext(node3);
        return node1;
    }
}
