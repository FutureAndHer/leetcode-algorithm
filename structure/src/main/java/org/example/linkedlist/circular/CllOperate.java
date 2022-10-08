package org.example.linkedlist.circular;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 循环链表的基本操作
 *
 * @className: CllOperate
 * @author: Max Solider
 * @date: 2022-10-08 21:57
 */
public class CllOperate {

    /**
     * 遍历链表
     *
     * @param headNode
     * @return int 链表长度
     * @author: Max Solider
     * @date: 2022/10/8 21:59
     */
    static int listLength(CllNode headNode) {
        if (headNode == null) {
            return 0;
        }
        CllNode currentNode = headNode;
        int count = 1;
        do {
            System.out.println("第" + count + "个结点的值是：" + currentNode.getData());
            currentNode = currentNode.getNext();
            count++;
        } while (currentNode != headNode);
        return count - 1;
    }

    /**
     * 表尾插入新结点
     *
     * @param headNode
     * @param newNode
     * @return org.example.linkedlist.circular.CllNode
     * @author: Max Solider
     * @date: 2022/10/8 22:14
     */
    static CllNode insertTail(CllNode headNode, CllNode newNode) {
        if (headNode == null) {
            headNode = newNode;
            headNode.setNext(newNode);
            return headNode;
        }
        // 找到原表尾结点
        CllNode oldTailNode = headNode;
        do {
            oldTailNode = oldTailNode.getNext();
        } while (oldTailNode.getNext() != headNode);
        // 插入新表尾结点
        oldTailNode.setNext(newNode);
        newNode.setNext(headNode);
        return headNode;
    }

    /**
     * 链表头插入新结点
     *
     * @param headNode
     * @param newNode
     * @return org.example.linkedlist.circular.CllNode
     * @author: Max Solider
     * @date: 2022/10/8 22:29
     */
    static CllNode insertHead(CllNode headNode, CllNode newNode) {
        if (headNode == null) {
            headNode = newNode;
            headNode.setNext(newNode);
            return headNode;
        }
        if (newNode == null) {
            return headNode;
        }
        // 更新头结点
        newNode.setNext(headNode);
        headNode = newNode;
        // 更新尾结点信息
        CllNode tailNode = headNode.getNext();
        do {
            tailNode = tailNode.getNext();
        } while (tailNode.getNext() != headNode.getNext());
        tailNode.setNext(headNode);
        return headNode;
    }

    /**
     * 删除表尾结点
     *
     * @param headNode
     * @return org.example.linkedlist.circular.CllNode
     * @author: Max Solider
     * @date: 2022/10/8 22:42
     */
    static CllNode deleteTail(CllNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        if (headNode.getNext() == headNode) {
            headNode.setNext(null);
            headNode = null;
            return headNode;
        }
        // 找到表尾结点的前驱结点
        CllNode currentNode = headNode;
        while (currentNode.getNext().getNext() != headNode) {
            currentNode = currentNode.getNext();
        }
        // 更新表尾结点信息
        currentNode.getNext().setNext(null);
        // 更新表尾结点的前驱结点的信息
        currentNode.setNext(headNode);
        return headNode;
    }

    /**
     * 删除表头结点
     *
     * @author: Max Solider
     * @date: 2022/10/8 22:54
     * @param headNode
     * @return org.example.linkedlist.circular.CllNode
     */
    static CllNode deleteHead(CllNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        if (headNode.getNext() == headNode) {
            headNode.setNext(null);
            headNode = null;
            return headNode;
        }
        // 更新表尾结点
        CllNode tailNode = headNode;
        while (tailNode.getNext() != headNode) {
            tailNode = tailNode.getNext();
        }
        tailNode.setNext(headNode.getNext());
        // 更新头指针
        CllNode oldHead = headNode;
        headNode = headNode.getNext();
        // 更新原头结点
        oldHead.setNext(null);
        oldHead = null;
        return headNode;
    }

    public static void main(String[] args) {
        CllNode headNode = initList();
        // 1. 遍历链表
//        listLength(headNode);
        // 2. 链表插入新表尾结点
//        CllNode newNode = new CllNode(18);
//        headNode = insertTail(headNode, newNode);
        // 3. 链表插入新表头结点
//        CllNode newNode = new CllNode(18);
//        headNode = insertHead(headNode, newNode);
        // 4. 删除链表表尾结点
//        headNode = deleteTail(headNode);
        // 5. 删除链表头结点
        headNode = deleteHead(headNode);
        listLength(headNode);
    }

    /**
     * 初始化链表
     *
     * @return CllNode
     * @author: Max Solider
     * @date: 2022/10/8 21:59
     */
    static CllNode initList() {
        CllNode node1 = new CllNode(1);
        CllNode node2 = new CllNode(2);
        CllNode node3 = new CllNode(3);
        CllNode node4 = new CllNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node1);
        return node1;
    }
}
