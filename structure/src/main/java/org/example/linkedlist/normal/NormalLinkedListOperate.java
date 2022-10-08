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

    /**
     * 表头插入新结点
     *
     * @param: 链表头, 新结点
     * @return: NormalListNode 新链表头
     * @author: Max Solider
     * @date: 2022/10/8 10:48
     */
    static NormalListNode insertHead(NormalListNode headNode, NormalListNode newNode) {
        if (newNode == null) {
            return headNode;
        }
        newNode.setNext(headNode);
        headNode = newNode;
        return headNode;
    }

    /**
     * 表尾插入新结点
     *
     * @param: 链表头, 新结点
     * @return: NormalListNode 链表头
     * @author: Max Solider
     * @date: 2022/10/8 10:48
     */
    static NormalListNode insertTail(NormalListNode headNode, NormalListNode newNode) {
        // 如果是空链表，或新结点是null，则直接返回
        if (headNode == null || newNode == null) {
            return headNode;
        }
        NormalListNode current = headNode;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        return headNode;
    }

    /**
     * 任意位置插入新结点
     *
     * @param headNode 链表表头
     * @param newNode  新结点
     * @param position 待插入位置
     * @return 新链表表头
     */
    static NormalListNode insert(NormalListNode headNode, NormalListNode newNode, int position) {
        int size = listLength(headNode);
        // 插入位置合法性校验
        if (position < 1 || position > size + 1) {
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
            return headNode;
        }
        // 如果是在表头插入
        if (position == 1) {
            return insertHead(headNode, newNode);
        }
        // 表尾或中间位置插入，先找到待插入位置前一个结点
        int currentPosition = 1;
        NormalListNode previousNode = headNode;
        while (currentPosition != position - 1) {
            previousNode = previousNode.getNext();
            currentPosition++;
        }
        // 将新结点的next指针指向待插入位置的原结点
        newNode.setNext(previousNode.getNext());
        // 将待插入位置前一个结点的next指针指向新结点
        previousNode.setNext(newNode);
        return headNode;
    }


    /**
     * 执行方法
     *
     * @return: void
     * @author: Max Solider
     * @date: 2022/10/8 00:35
     */
    public static void main(String[] args) {
        NormalListNode headNode = initList();
        // 1. 遍历链表
//        listLength(headNode);
        // 2. 表头插入新结点
//        NormalListNode newNode = new NormalListNode(8);
//        headNode = insertHead(headNode, newNode);
        // 3. 表尾插入新结点
//        NormalListNode newNode = new NormalListNode(8);
//        headNode = insertTail(headNode, newNode);
        // 4. 任意位置插入新结点
        NormalListNode newNode = new NormalListNode(8);
//        headNode = insert(headNode, newNode, 1);
//        listLength(headNode);
//        headNode = insert(headNode, newNode, 2);
//        listLength(headNode);
//        headNode = insert(headNode, newNode, 4);
//        listLength(headNode);
//        headNode = insert(headNode, newNode, 5);
//        listLength(headNode);
        headNode = insert(headNode, newNode, 6);
        listLength(headNode);
    }

    /**
     * 初始化链表
     * []
     *
     * @return: NormalListNode 链表头
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
