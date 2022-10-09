package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 逆置单向链表
 *
 * @className: FindLoopLength
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class ReverseList {

    /**
     * 逆置单向链表
     *
     * @param headNode
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static NormalListNode reverseList(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        NormalListNode nextNode = null;
        NormalListNode previousNode = null;
        while (headNode != null) {
            nextNode = headNode.getNext();
            headNode.setNext(previousNode);
            previousNode = headNode;
            headNode = nextNode;
        }
        headNode = previousNode;
        return headNode;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        headNode = reverseList(headNode);
        listLength(headNode);
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
        while (currentNode != null) {
            count++;
            System.out.println("链表第" + count + "个结点的值是：" + currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return count;
    }
}
