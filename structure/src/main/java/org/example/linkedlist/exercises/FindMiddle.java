package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 找到单向链表的中间结点
 *
 * @className: FindMiddle
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class FindMiddle {

    /**
     * 找到单向链表的中间结点
     *
     * @param headNode
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static NormalListNode findMiddle(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        NormalListNode slowPtr = headNode;
        NormalListNode fastPtr = headNode.getNext();
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        NormalListNode middleNode = null;
        if (fastPtr.getNext() == null) {
            middleNode = slowPtr;
        } else {
            middleNode = slowPtr.getNext();
        }
        System.out.println("The middle node of linked lis is " + middleNode.getData());
        return middleNode;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        NormalListNode middleNode = findMiddle(headNode);
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
//        NormalListNode node6 = new NormalListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
//        node5.setNext(node6);
        return node1;
    }

}
