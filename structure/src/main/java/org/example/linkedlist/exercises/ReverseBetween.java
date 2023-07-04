package org.example.linkedlist.exercises;

/**
 * 链表表内指定区间翻转
 *
 * @className: ReverseBetween
 * @author: Max Solider
 * @date: 2023-07-04 22:15
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverseNode = reverseBetween(node1, 2, 4);
        System.out.println(reverseNode);
    }

    /**
     * 翻转链表指定区间
     *
     * @param head 链表头结点
     * @param m    翻转区间起始位置
     * @param n    翻转区间结束位置
     * @return 翻转后链表
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 判断参数是否合法
        if (head == null || head.next == null || m < 0 || m > n) {
            return head;
        }
        // 1. 先用虚拟头结点指向原始链表头，便于后续翻转链表
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 2. 找到翻转区间起始位置,并记录翻转区间前一个结点
        ListNode beforeReverse = dummyHead;
        ListNode reverseHead = dummyHead;
        for (int i = 0; i < m; i++) {
            beforeReverse = reverseHead;
            reverseHead = reverseHead.next;
        }
        // 3. 从翻转区间起始位置开始依次逆置链表，直到结束位置
        ListNode current = reverseHead;
        ListNode pre = null;
        for (int i =  m - 1; i < n; i++) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        // 4. 此时，current结点就是翻转区间后一个结点
        ListNode afterReverse = current;
        // 5. 将翻转区间前一个结点的next指针指向翻转区间翻转后的头结点
        beforeReverse.next = pre;
        // 7. 将翻转区间翻转后的尾结点指向原翻转区间后一个结点
        reverseHead.next = afterReverse;
        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
