package org.example.linkedlist.dll;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 双向链表基本操作
 *
 * @className: DllOperate
 * @author: Max Solider
 * @date: 2022-10-08 17:08
 */
public class DllOperate {

    /**
     * 遍历链表，并返回链表长度
     *
     * @param: headNode 链表头结点
     * @return: int 链表长度
     * @author: Max Solider
     * @date: 2022/10/8 00:39
     */
    static int listLength(DllNode headNode) {
        DllNode currentNode = headNode;
        int count = 0;
        while (currentNode != null) {
            count++;
            System.out.println("链表第" + count + "个结点的值是：" + currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return count;
    }

    /**
     * 在双向链表头前插入新结点
     *
     * @param headNode 原链表头结点
     * @param newNode  新结点
     * @return DllNode
     * @author: Max Solider
     * @date: 2022/10/8 17:12
     */
    static DllNode insertHead(DllNode headNode, DllNode newNode) {
        if (newNode == null) {
            return headNode;
        }
        if (headNode == null) {
            return newNode;
        }
        // 改变原头结点的前驱指针
        headNode.setPrevious(newNode);
        // 改变新结点的后继指针
        newNode.setNext(headNode);
        headNode = newNode;
        return headNode;
    }

    /**
     * 在链表尾后插入新结点
     *
     * @param headNode 链表头结点指针
     * @param newNode  新结点
     * @return DllNode 新的表头指针
     * @author: Max Solider
     * @date: 2022/10/8 17:21
     */
    static DllNode insertTail(DllNode headNode, DllNode newNode) {
        if (headNode == null) {
            return newNode;
        }
        if (newNode == null) {
            return headNode;
        }
        DllNode currentNode = headNode;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        newNode.setPrevious(currentNode);
        newNode.setNext(null);
        return headNode;
    }

    /**
     * 双向链表中任意位置插入结点
     *
     * @param headNode 链表头指针
     * @param newNode  新结点
     * @param position 待插入位置
     * @return DllNode
     * @author: Max Solider
     * @date: 2022/10/8 17:47
     */
    static DllNode insert(DllNode headNode, DllNode newNode, int position) {
        if (headNode == null) {
            headNode = newNode;
            return headNode;
        }
        if (position < 1) {
            System.out.println("The position of node to insert is invalid. The position must be greater than 0.");
            return headNode;
        }
        if (position == 1) {
            // 改变原头结点的前驱指针
            headNode.setPrevious(newNode);
            // 改变新结点的后继指针
            newNode.setNext(headNode);
            headNode = newNode;
            return headNode;
        }
        // 先找到待插入位置的原结点
        int count = 1;
        DllNode currentNode = headNode;
        DllNode previousNode = currentNode.getPrevious();
        while (count != position) {
            if (currentNode == null) {
                System.out.println("The position of node to insert is invalid. The position must be less than " + (count + 1));
                return headNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            count++;
        }
        // 改变原结点前驱结点的后继指针
        previousNode.setNext(newNode);
        // 改变新结点的前驱指针和后继指针
        newNode.setPrevious(previousNode);
        newNode.setNext(currentNode);
        // 如果后继结点不是null，则修改后继结点的前驱指针
        if (currentNode != null) {
            currentNode.setPrevious(newNode);
        }
        return headNode;
    }

    /**
     * 删除表头结点
     *
     * @param headNode
     * @return org.example.linkedlist.dll.DllNode
     * @author: Max Solider
     * @date: 2022/10/8 19:38
     */
    static DllNode deleteHead(DllNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        // 如果链表只有一个元素
        if (headNode.getNext() == null) {
            headNode = null;
            return headNode;
        }
        // 将表头指针指向第二个结点
        DllNode newHead = headNode.getNext();
        // 修改将原表头结点的后继指针
        headNode.setNext(null);
        // 修改新表头结点的前驱指针
        newHead.setPrevious(null);
        headNode = newHead;
        return headNode;
    }

    /**
     * 删除表尾结点
     *
     * @param headNode
     * @return org.example.linkedlist.dll.DllNode
     * @author: Max Solider
     * @date: 2022/10/8 20:38
     */
    static DllNode deleteTail(DllNode headNode) {
        if (headNode == null || headNode.getNext() == null) {
            headNode = null;
            return headNode;
        }
        // 遍历找到表尾结点
        DllNode tailNode = headNode;
        while (tailNode.getNext() != null) {
            tailNode = tailNode.getNext();
        }
        tailNode.getPrevious().setNext(null);
        tailNode.setPrevious(null);
        return headNode;
    }

    /**
     * 删除任意结点
     *
     * @param headNode
     * @param position
     * @return org.example.linkedlist.dll.DllNode
     * @author: Max Solider
     * @date: 2022/10/8 20:58
     */
    static DllNode delete(DllNode headNode, int position) {
        if (headNode == null) {
            return headNode;
        }
        if (position < 1) {
            System.out.println("The position of node to delete is invalid. The position must be greater than 0");
            return headNode;
        }
        // 找到待删除结点
        DllNode deleteNode = headNode;
        int count = 1;
        while (count != position) {
            deleteNode = deleteNode.getNext();
            count++;
            if (deleteNode == null) {
                System.out.println("The position of node to delete is invalid. The position must be less than " + count);
                return headNode;
            }
        }
        // 更新待删除结点的前驱结点信息
        if (deleteNode.getPrevious() != null) {
            deleteNode.getPrevious().setNext(deleteNode.getNext());
        } else {
            // 如果删除的是表头结点，需要更新head指针
            headNode = deleteNode.getNext();
        }
        // 更新待删除结点的后继结点信息
        if (deleteNode.getNext() != null) {
            deleteNode.getNext().setPrevious(deleteNode.getPrevious());
        }
        // 更新待删除结点信息
        deleteNode.setPrevious(null);
        deleteNode.setNext(null);
        return headNode;
    }

    public static void main(String[] args) {
        DllNode headNode = initList();
        // 1. 在链表头前插入新结点
//        DllNode newNode = new DllNode(8);
//        headNode = insertHead(headNode, newNode);
        // 2. 在链表尾后插入新结点
//        DllNode newNode = new DllNode(8);
//        headNode = insertTail(headNode, newNode);
        // 3. 在链表任意位置插入新结点
//        DllNode newNode = new DllNode(8);
//        headNode = insert(headNode, newNode, 0);
//        headNode = insert(headNode, newNode, 1);
//        headNode = insert(headNode, newNode, 3);
//        headNode = insert(headNode, newNode, 5);
//        headNode = insert(headNode, newNode, 8);
        // 4. 删除表头结点
//        headNode = deleteHead(headNode);
        // 5. 删除表尾结点
//        headNode = deleteTail(headNode);
        // 6. 删除任意结点
//        headNode = delete(headNode, 0);
//        headNode = delete(headNode, 1);
//        headNode = delete(headNode, 2);
//        headNode = delete(headNode, 4);
//        headNode = delete(headNode, 5);
        listLength(headNode);
    }

    /**
     * 初始化链表
     *
     * @return: DllNode 链表头
     * @author: Max Solider
     * @date: 2022/10/8 16:36
     */
    static DllNode initList() {
        DllNode node1 = new DllNode(1);
        DllNode node2 = new DllNode(2);
        DllNode node3 = new DllNode(3);
        DllNode node4 = new DllNode(4);
        node1.setNext(node2);
        node1.setPrevious(null);
        node2.setNext(node3);
        node2.setPrevious(node1);
        node3.setNext(node4);
        node3.setPrevious(node2);
        node4.setPrevious(node3);
        return node1;
    }
}
