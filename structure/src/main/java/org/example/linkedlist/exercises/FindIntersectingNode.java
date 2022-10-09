package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 找到两个单向链表的合并点
 *
 * @className: FindIntersectingNode
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class FindIntersectingNode {

    /**
     * 找到两个单向链表的合并点
     *
     * @param firstHeadNode  第一个链表的表头指针
     * @param secondHeadNode 第二个链表的表头指针
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static NormalListNode findIntersectingNode(NormalListNode firstHeadNode, NormalListNode secondHeadNode) {
        if (firstHeadNode == null || secondHeadNode == null) {
            return null;
        }
        // 计算两个链表的长度
        int firstLength = getListLength(firstHeadNode);
        int secondLength = getListLength(secondHeadNode);
        // 计算两个链表的长度差值
        NormalListNode longerNode = null;
        NormalListNode shorterNode = null;
        int diffLength = 0;
        if (firstLength > secondLength) {
            longerNode = firstHeadNode;
            shorterNode = secondHeadNode;
            diffLength = firstLength - secondLength;
        } else {
            longerNode = secondHeadNode;
            shorterNode = firstHeadNode;
            diffLength = secondLength - firstLength;
        }
        // 将指向更长链表的指针向前移动，直到两个指针距离合并点的距离相同
        while (diffLength > 0) {
            longerNode = longerNode.getNext();
            diffLength--;
        }
        // 两个指针同时移动，相遇点即合并点。若没相遇则说明没有合并
        while (longerNode != null) {
            if (longerNode == shorterNode) {
                System.out.println("The merging point of two linked lists is " + longerNode.getData());
                return longerNode;
            }
            longerNode = longerNode.getNext();
            shorterNode = shorterNode.getNext();
        }
        System.out.println("The is no merging point of two linked lists.");
        return null;
    }

    /**
     * 计算链表长度
     *
     * @param headNode 链表头指针
     * @return int 链表长度
     * @author: Max Solider
     * @date: 2022/10/9 16:36
     */
    static int getListLength(NormalListNode headNode) {
        if (headNode == null) {
            return 0;
        }
        int count = 0;
        NormalListNode node = headNode;
        while (node != null) {
            node = node.getNext();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NormalListNode node17 = new NormalListNode(17);
        NormalListNode node8 = new NormalListNode(8);
        NormalListNode node11 = new NormalListNode(11);
        NormalListNode node23 = new NormalListNode(23);
        NormalListNode node1 = new NormalListNode(1);
        NormalListNode node2 = new NormalListNode(2);
        NormalListNode node3 = new NormalListNode(3);
        NormalListNode node4 = new NormalListNode(4);
        NormalListNode node5 = new NormalListNode(5);
        node17.setNext(node8);
        node8.setNext(node11);
        node11.setNext(node3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        NormalListNode firstHeadNode = node17;
        NormalListNode secondHeadNode = node1;
        NormalListNode intersectingNode = findIntersectingNode(firstHeadNode, secondHeadNode);
        listLength(intersectingNode);
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
