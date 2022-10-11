package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 等长分割循环链表
 *
 * @className: SplitCircularList
 * @author: Max Solider
 * @date: 2022-10-11 22:38
 */
public class SplitCircularList {

    /**
     * 等长分割循环链表
     *
     * @param headNode
     * @author: Max Solider
     * @date: 2022/10/11 22:39
     */
    static void splitCircularList(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null || headNode.getNext() == headNode) {
            System.out.println("The linked list cannot be divided into two.");
            return;
        }
        NormalListNode slowPtr = headNode;
        NormalListNode fastPtr = headNode;
        while (fastPtr.getNext() != headNode && fastPtr.getNext().getNext() != headNode) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        if (fastPtr.getNext() != headNode) {
            fastPtr = fastPtr.getNext();
        }
        NormalListNode aList = headNode;
        NormalListNode bList = slowPtr.getNext();
        slowPtr.setNext(aList);
        fastPtr.setNext(bList);
        listLength(aList);
        System.out.println("========");
        listLength(bList);
    }

    public static void main(String[] args) {
        NormalListNode list = initList();
        splitCircularList(list);
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
//        node5.setNext(node1);
        node5.setNext(node6);
        node6.setNext(node1);
        return node1;
    }


    /**
     * 遍历链表，并返回链表长度
     *
     * @param: headNode 链表头结点
     * @return: int 链表长度
     * @author: Max Solider
     * @date: 2022/10/8 00:39
     */
    static int listLength(NormalListNode headNode) {
        NormalListNode currentNode = headNode;
        int count = 0;
        do {
            count++;
            System.out.println("链表第" + count + "个结点的值是：" + currentNode.getData());
            currentNode = currentNode.getNext();
        } while (currentNode != headNode);
        return count;
    }
}
