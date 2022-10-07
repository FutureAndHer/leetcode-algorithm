package org.example.linkedlist.normal;

/**
 * 普通单向链表的相关操作
 *
 * @className: NormalLinkedListOperate
 * @author: Max Solider
 * @date: 2022-10-08 00:30
 */
public class NormalLinkedListOperate {

    /**
     * 遍历链表，并返回链表长度
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

    /**
     * 执行方法
     * @return: void
     * @author: Max Solider
     * @date: 2022/10/8 00:35
     */
    public static void main(String[] args) {
        NormalListNode headNode = initList();
        listLength(headNode);
    }

    /**
     * 初始化链表
     * []
     * @return: org.example.linkedlist.normal.NormalListNode 链表头
     * @author: Max Solider
     * @date: 2022/10/8 00:36
     */
    private static NormalListNode initList() {
        NormalListNode node1 = new NormalListNode(1);
        NormalListNode node2 = new NormalListNode(2);
        NormalListNode node3 = new NormalListNode(3);
        NormalListNode node4 = new NormalListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return node1;
    }
}
