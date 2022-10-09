package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 逆序输出单向链表
 *
 * @className: PrintListFromEnd
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class PrintListFromEnd {

    /**
     * 逆序输出单向链表
     *
     * @param headNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static void printListFromEnd(NormalListNode headNode) {
        if (headNode == null) {
            return;
        }
        printListFromEnd(headNode.getNext());
        System.out.println(" " + headNode.getData() + " ");
        return;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        printListFromEnd(headNode);
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
        NormalListNode node6 = new NormalListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        return node1;
    }

}
