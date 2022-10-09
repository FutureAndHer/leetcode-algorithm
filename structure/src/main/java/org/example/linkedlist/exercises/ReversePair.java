package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 逐对逆置链表
 *
 * @className: ReversePair
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class ReversePair {

    /**
     * 逐对逆置链表-递归版本
     *
     * @author: Max Solider
     * @date: 2022/10/9 21:58
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     */
    static NormalListNode reversePairRecursive(NormalListNode headNode) {
        // 递归的基本情形是遍历结束 或 只剩下最后一个结点
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        // 成对逆置结点
        NormalListNode tempNode = headNode.getNext();
        headNode.setNext(tempNode.getNext());
        tempNode.setNext(headNode);
        headNode = tempNode;
        headNode.getNext().setNext(reversePairRecursive(headNode.getNext().getNext()));
        return headNode;
    }

    /**
     * 逐对逆置链表-遍历迭代版本
     *
     * @author: Max Solider
     * @date: 2022/10/9 21:58
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     */
    static NormalListNode reversePairIterative(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        NormalListNode ptr1 = null;
        NormalListNode ptr2 = null;
        while (headNode != null && headNode.getNext() != null) {
            if (ptr1 != null) {
                ptr1.getNext().setNext(headNode.getNext());
            }
            ptr1 = headNode.getNext();
            headNode.setNext(headNode.getNext().getNext());
            ptr1.setNext(headNode);
            if (ptr2 == null) {
                ptr2 = ptr1;
            }
            headNode = headNode.getNext();
        }
        return ptr2;
    }

    public static void main(String[] args) {
        System.out.println("递归版本：");
        NormalListNode headNode = initList();
        headNode = reversePairRecursive(headNode);
        listLength(headNode);

        System.out.println("============");
        System.out.println("遍历迭代版本：");
        headNode = initList();
        headNode = reversePairIterative(headNode);
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
//        NormalListNode node6 = new NormalListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
//        node5.setNext(node6);
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
