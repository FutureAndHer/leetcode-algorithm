package org.example.linkedlist.exercises;

/**
 * 删除有序链表中重复的元素
 * 如：给出的链表为1→2→3→3→4→4→5, 返回1→2→5.
 * 给出的链表为1→1→1→2→3, 返回2→3.
 *
 * @className: DeleteDuplicates
 * @author: Max Solider
 * @date: 2023-07-04 22:56
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
//        node2.next = node3;
        node3.next = node33;
//        node33.next = node4;
        node4.next = node44;
        node44.next = node5;
        ListNode newHead = deleteDuplicates(node1);
        System.out.println(newHead);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        // 检查输入参数是否合法
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 构造虚拟头结点,指向原链表头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 2. 用pre和fast两个指针，pre指针初始值指向虚拟头结点，fast指向pre指针的next.next结点
        ListNode pre = dummyNode;
        ListNode fast = pre.next.next;
        // 3. pre指针遍历链表，同时fast从pre指针的next.next结点开始遍历，若pre.next和fast指针相等，则fast继续往后遍历，
        // 直到pre.next和fast不等为止，更新pre.next的值，指向fast结点
        while (pre.next != null && pre.next.next != null) {
            boolean hasDuplicateNode = false;
            fast = pre.next.next;
            while (fast != null && pre.next.val == fast.val) {
                fast = fast.next;
                hasDuplicateNode = true;
            }
            if (hasDuplicateNode) {
                pre.next = fast;
            } else {
                pre = pre.next;
            }
            hasDuplicateNode = false;
        }
        // 4. 返回新的链表
        return dummyNode.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
