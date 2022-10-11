package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 判定链表是否是回文
 *
 * @className: IfPalindromeList
 * @author: Max Solider
 * @date: 2022-10-11 22:38
 */
public class IfPalindromeList {

    /**
     * 判定链表是否是回文
     *
     * @param headNode
     * @author: Max Solider
     * @date: 2022/10/11 22:39
     */
    static boolean ifPalindromeList(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null || headNode.getNext() == headNode) {
            System.out.println("The linked list is palindrome list.");
            return true;
        }
        // 先找到中间结点
        NormalListNode slowPtr = headNode;
        NormalListNode fastPtr = headNode;
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        // 逆置后半部分链表
        NormalListNode secondHalf = reverseList(slowPtr.getNext());
        NormalListNode firstHalf = headNode;
        NormalListNode secondHalfHead = secondHalf;
        boolean palindrome = false;
        // 因为链表长度可能是奇数，前半部分可能会比后半部分多一个数据，所以用后半部分的长度来遍历
        while (secondHalf != null) {
            if (secondHalf.getData() != firstHalf.getData()) {
                break;
            }
            secondHalf = secondHalf.getNext();
            firstHalf = firstHalf.getNext();
        }
        if (palindrome) {
            System.out.println("The linked list is palindrome list.");
        } else {
            System.out.println("The lined list is not palindrome list.");
        }
        // 还原后半部分链表
        reverseList(secondHalfHead);
        listLength(headNode);
        return true;
    }

    /**
     * 逆置链表
     *
     * @author: Max Solider
     * @date: 2022/10/11 23:26
     * @param headNode
     * @return org.example.linkedlist.normal.NormalListNode
     */
    static NormalListNode reverseList(NormalListNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        NormalListNode current = headNode;
        NormalListNode previous = null;
        while (current != null) {
            NormalListNode temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        NormalListNode list = initList();
        ifPalindromeList(list);
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
        NormalListNode node4 = new NormalListNode(2);
        NormalListNode node5 = new NormalListNode(1);
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
