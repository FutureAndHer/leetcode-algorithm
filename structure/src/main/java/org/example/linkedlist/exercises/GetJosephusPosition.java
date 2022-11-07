package org.example.linkedlist.exercises;

import org.example.linkedlist.circular.CllNode;
import org.example.linkedlist.normal.NormalListNode;

/**
 * 约瑟夫环
 * N个人想选出一个领头人，他们排成一个环，沿着环每数到第M个人就从环中排除该人，并从下一个人开始重新数。请找出最后留在环中的人。
 *
 * @className: CllOperate
 * @author: Max Solider
 * @date: 2022-10-08 21:57
 */
public class GetJosephusPosition {

    /**
     * 找到约瑟夫环结点
     *
     * @param n 共n个人
     * @param m 需要排除第m个结点
     * @return 最后剩下的结点
     */
    private static NormalListNode getJosephusPosition(int n, int m) {
        if (n < 1) {
            return null;
        }
        // 生成循环链表
        NormalListNode head = new NormalListNode(1);
        NormalListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.setNext(new NormalListNode(i + 1));
            cur = cur.getNext();
        }
        cur.setNext(head);
        // 获取约瑟夫环节点
        return getJosephusPosition(head, m);
    }

    /**
     * 找到约瑟夫环结点
     *
     * @param headNode 头结点
     * @param m        需要排除第m个结点
     * @return 最后剩下的结点
     */
    private static NormalListNode getJosephusPosition(NormalListNode headNode, int m) {
        if (headNode == null || headNode.getNext() == headNode) {
            return headNode;
        }
        NormalListNode cur = headNode;
        NormalListNode previous = null;
        while (cur.getNext() != cur) {
            int count = m;
            while (--count > 0) {
                previous = cur;
                cur = cur.getNext();
            }
            previous.setNext(cur.getNext());
            cur = cur.getNext();
        }
        return cur;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 6;
//        NormalListNode headNode = initList();
//        NormalListNode node = getJosephusPosition(headNode, m);
        NormalListNode node = getJosephusPosition(n, m);
        System.out.println("The last player is " + node.getData());
    }


    /**
     * 初始化链表
     *
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/11/7 21:59
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
        node6.setNext(node1);
        return node1;
    }
}
