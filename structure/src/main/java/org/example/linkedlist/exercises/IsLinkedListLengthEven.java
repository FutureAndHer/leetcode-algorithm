package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 判断链表结点数是奇数还是偶数
 *
 * @className: IsLinkedListLengthEven
 * @author: Max Solider
 * @date: 2022-10-09 10:43
 */
public class IsLinkedListLengthEven {

    /**
     * 判断链表结点数是否为偶数
     *
     * @param headNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static boolean isLinkedListLengthEven(NormalListNode headNode) {
        if (headNode == null) {
            System.out.println("The length of linked list is even");
            return true;
        }
        NormalListNode ptr = headNode;
        while (ptr != null) {
            if (ptr.getNext() == null) {
                System.out.println("The length of linked list is not even");
                return false;
            }
            ptr = ptr.getNext().getNext();
        }
        System.out.println("The length of linked list is even");
        return true;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        isLinkedListLengthEven(headNode);
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

}
