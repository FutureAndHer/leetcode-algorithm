package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 合并两个有序链表
 *
 * @className: MergeList
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class MergeList {

    /**
     * 合并两个有序链表
     *
     * @param headNode1 链表1
     * @param headNode2 链表2
     * @return NormalListNode 新的链表表头指针
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static NormalListNode mergeList(NormalListNode headNode1, NormalListNode headNode2) {
        if (headNode1 == null) {
            return headNode2;
        }
        if (headNode2 == null) {
            return headNode1;
        }
        NormalListNode result = null;
        if (headNode1.getData() <= headNode2.getData()) {
            result = headNode1;
            result.setNext(mergeList(headNode1.getNext(), headNode2));
        } else {
            result = headNode2;
            result.setNext(mergeList(headNode1, headNode2.getNext()));
        }
        return result;
    }

    public static void main(String[] args) {
        NormalListNode headNode1 = initList(1, 3, 4, 7, 10);
        NormalListNode headNode2 = initList(2, 3, 5, 11, 13);
        NormalListNode result = mergeList(headNode1, headNode2);
        listLength(result);
    }

    /**
     * 初始化链表
     *
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 10:44
     */
    static NormalListNode initList(int a, int b, int c, int d, int e) {
        NormalListNode node1 = new NormalListNode(a);
        NormalListNode node2 = new NormalListNode(b);
        NormalListNode node3 = new NormalListNode(c);
        NormalListNode node4 = new NormalListNode(d);
        NormalListNode node5 = new NormalListNode(e);
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
