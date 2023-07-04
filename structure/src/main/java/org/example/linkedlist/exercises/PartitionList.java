package org.example.linkedlist.exercises;

/**
 * 划分链表
 * 给出一个长度为n的单链表和一个值x，单链表的每一个值为listi，
 * 请返回一个链表的头结点，要求新链表中小于x的节点全部在大于等于x的节点左侧，
 * 并且两个部分之内的节点之间与原来的链表要保持相对顺序不变。
 * 例如：给出1→4→3→2→5→2 和 x=3
 * 输出：返回1→2→2→4→3→5
 * @className: PartitionList
 * @author: Max Solider
 * @date: 2023-07-04 22:33
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node22 = new ListNode(2);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node22;
        ListNode newHead = partition(node1, 3);
        System.out.println(newHead);
    }

    public static ListNode partition(ListNode head, int x) {
        // 1.检查输入参数是否合法
        if (head == null) {
            return head;
        }
        // 2.维护一个small链表和一个big链表
        ListNode smallDummyHead = new ListNode(-1);
        ListNode bigDummyHead = new ListNode(-1);
        // 3.遍历原链表，将小于x的结点放入small链表；将大于等于x的结点放入big链表
        ListNode original = head;
        ListNode small = smallDummyHead;
        ListNode big = bigDummyHead;
        while (original != null) {
            if (original.val < x) {
                small.next = original;
                small = small.next;
            } else {
                big.next = original;
                big = big.next;
            }
            original = original.next;
        }
        // 4.将big链表尾结点的next指针指向null
        big.next = null;
        // 5.拼接small链表和big链表
        small.next = bigDummyHead.next;
        return smallDummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
