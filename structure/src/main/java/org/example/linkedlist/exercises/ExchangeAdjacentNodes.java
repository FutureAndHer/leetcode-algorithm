package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 交换链表中的相邻结点
 *
 * @className: ExchangeAdjacentNodes
 * @author: Max Solider
 * @date: 2022-10-12 23:43
 */
public class ExchangeAdjacentNodes {

    /**
     * 交换链表中的相邻结点
     *
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/12 23:39
     */
    static NormalListNode exchangeAdjacentNodes(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        NormalListNode current = headNode;
        headNode = current.getNext();
        while (current != null && current.getNext() != null) {
            NormalListNode next = current.getNext();
            // 逐对进行交换
            NormalListNode temp = next.getNext();
            next.setNext(current);
            // 需要注意链表结点奇偶性
            if (temp != null && temp.getNext() != null) {
                current.setNext(temp.getNext());
            } else {
                current.setNext(temp);
            }
            current = temp;
        }
        return headNode;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        headNode = exchangeAdjacentNodes(headNode);
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
        NormalListNode node6 = new NormalListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
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
