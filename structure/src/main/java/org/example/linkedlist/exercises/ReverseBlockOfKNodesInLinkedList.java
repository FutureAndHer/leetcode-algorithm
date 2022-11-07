package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 逆置链表中包含K个结点的块
 *
 * @className: ReverseBlockOfKNodesInLinkedList
 * @author: Max Solider
 * @date: 2022-10-13 23:43
 */
public class ReverseBlockOfKNodesInLinkedList {

    /**
     * 逆置链表中包含K个结点的块
     *
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/13 23:39
     */
    static NormalListNode reverseBlockOfKNodesInLinkedList(NormalListNode headNode, int k) {
        if (headNode == null || headNode.getNext() == null || !hasKNodes(headNode, k)) {
            return headNode;
        }
        NormalListNode newHead = null;
        NormalListNode start = headNode;
        NormalListNode kNode = getKthNode(start, k);
        NormalListNode kPlusOneNode = kNode.getNext();
        NormalListNode newStart = reverseBlock(start, k);
        start.setNext(reverseBlockOfKNodesInLinkedList(kPlusOneNode, k));
        if (newHead == null) {
            newHead = newStart;
        }
        return newHead;
    }

    /**
     * 逆置链表块
     *
     * @param head 开始结点
     * @param k    数量
     * @return 逆置后的链表块头
     */
    private static NormalListNode reverseBlock(NormalListNode head, int k) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        NormalListNode cur = head;
        NormalListNode previous = null;
        NormalListNode next = null;
        while (cur != null && k > 0) {
            next = cur.getNext();
            cur.setNext(previous);
            previous = cur;
            cur = next;
            k--;
        }
        return previous == null ? cur : previous;
    }

    /**
     * 获取从head开始第k个结点
     *
     * @param head 开始结点
     * @param k    数量
     * @return 第k个结点
     */
    private static NormalListNode getKthNode(NormalListNode head, int k) {
        NormalListNode start = head;
        while (--k > 0) {
            start = start.getNext();
        }
        return start;
    }

    /**
     * 判断从head开始，是否还有k个结点
     *
     * @param head 开始结点
     * @param k    数量
     * @return true 有k个结点，false 没有
     */
    private static boolean hasKNodes(NormalListNode head, int k) {
        if (head == null) {
            return false;
        }
        NormalListNode start = head;
        while (k > 0) {
            if (start == null) {
                return false;
            }
            start = start.getNext();
            k--;
        }
        return true;
    }


    public static void main(String[] args) {
        NormalListNode headNode = initList();
        int k = 7;
        headNode = reverseBlockOfKNodesInLinkedList(headNode, k);
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
