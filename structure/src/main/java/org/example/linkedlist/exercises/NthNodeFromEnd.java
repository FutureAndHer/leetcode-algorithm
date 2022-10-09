package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 找到链表倒数第n个结点
 *
 * @className: NthNodeFromEnd
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class NthNodeFromEnd {

    /**
     * 找到链表倒数第n个结点
     *
     * @param headNode
     * @param n
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 10:45
     */
    static NormalListNode findNthNodeFromEnd(NormalListNode headNode, int n) {
        if (headNode == null) {
            return headNode;
        }
        if (n < 1) {
            System.out.println("The N is invalid. The N must be greater than 0.");
            return null;
        }
        NormalListNode p1 = headNode, p2 = headNode;
        int count = 1;
        while (count != n) {
            p2 = p2.getNext();
            if (p2 == null) {
                System.out.println("The N is invalid. The N must be less than " + (count + 1));
                return null;
            }
            count++;
        }
        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        System.out.println("倒数第" + n + "个结点的值是：" + p1.getData());
        return p1;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        findNthNodeFromEnd(headNode, 0);
        findNthNodeFromEnd(headNode, 1);
        findNthNodeFromEnd(headNode, 2);
        findNthNodeFromEnd(headNode, 4);
        findNthNodeFromEnd(headNode, 5);
        findNthNodeFromEnd(headNode, 8);
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
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return node1;
    }
}
