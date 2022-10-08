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
     * 删除表头结点
     *
     * @param: headNode
     * @return: NormalListNode 新的表头结点
     * @author: Max Solider
     * @date: 2022/10/8 14:55
     */
    static NormalListNode deleteHead(NormalListNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        NormalListNode newHead = headNode.getNext();
        headNode.setNext(null);
        headNode = null;
        return newHead;
    }

    /**
     * 删除表尾结点
     *
     * @param: [headNode]
     * @return: NormalListNode
     * @author: Max Solider
     * @date: 2022/10/8 15:14
     */
    static NormalListNode deleteTail(NormalListNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        // 如果链表只有一个元素结点
        if (headNode.getNext() == null) {
            headNode = null;
            return headNode;
        }
        NormalListNode previousNode = headNode;
        // 遍历找到待删除结点前一个元素结点
        while (previousNode.getNext().getNext() != null) {
            previousNode = previousNode.getNext();
        }
        NormalListNode oldTail = previousNode.getNext();
        oldTail = null;
        previousNode.setNext(null);
        return headNode;
    }

    /**
     * 删除任意位置元素结点
     *
     * @param headNode 链表头结点
     * @param position 待删除位置
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/10/8 15:34
     */
    static NormalListNode delete(NormalListNode headNode, int position) {
        // 如果是空链表，或者待删除位置不合法
        if (headNode == null || position < 1) {
            System.out.println("Position of node to delete is invalid. The position must be greater than 0");
            return headNode;
        }
        // 如果是删除第一个元素结点
        if (position == 1) {
            NormalListNode deleteNode = headNode;
            headNode = deleteNode.getNext();
            deleteNode = null;
            return headNode;
        }
        // 遍历找到待删除位置的前一个元素
        int currentPosition = 1;
        NormalListNode previousNode = headNode;
        while (currentPosition != position - 1) {
            previousNode = previousNode.getNext();
            currentPosition++;
            // 如果previousNode的下一个结点已经都是null了，还没走到待删除位置，说明待删除位置不合法
            if (previousNode.getNext() == null) {
                System.out.println("Position of node to delete is invalid. The position must be less than " + currentPosition);
                return headNode;
            }
        }
        NormalListNode deleteNode = previousNode.getNext();
        // 将待删除位置的前一个元素的next指针指向待删除位置的下一个元素
        previousNode.setNext(deleteNode.getNext());
        // 移除待删除位置的元素
        deleteNode.setNext(null);
        deleteNode = null;
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
//        NormalListNode newNode = new NormalListNode(8);
//        headNode = insert(headNode, newNode, 1);
//        headNode = insert(headNode, newNode, 2);
//        headNode = insert(headNode, newNode, 4);
//        headNode = insert(headNode, newNode, 5);
//        headNode = insert(headNode, newNode, 6);
        // 5. 删除表头结点
//        headNode = deleteHead(headNode);
        // 6. 删除表尾结点
//        headNode = deleteTail(headNode);
        // 7. 删除链表任意结点
//        headNode = delete(headNode, 0);
//        headNode = delete(headNode, 1);
//        headNode = delete(headNode, 4);
//        headNode = delete(headNode, 5);
//        headNode = delete(headNode, 7);
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
    static NormalListNode initList() {
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
