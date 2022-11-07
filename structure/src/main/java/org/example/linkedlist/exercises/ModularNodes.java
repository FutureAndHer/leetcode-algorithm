package org.example.linkedlist.exercises;

import org.example.linkedlist.normal.NormalListNode;

/**
 * 寻找最后一个模结点
 * 给定一个单向链表，链表的结点编号i为*1,2,3,...,n*，其中n为链表中元素的个数，编写一个函数从表头开始找到最后一个满足*i%k=0*条件的元素，k是一个整数常量。例如，如果n为19，k为3，那么应该返回第18个结点
 *
 * @className: ModularNodes
 * @author: Max Solider
 * @date: 2022-11-07 10:43
 */
public class ModularNodes {

    /**
     * 寻找最后一个模结点
     *
     * @param headNode
     * @return NormalListNode
     * @author: Max Solider
     * @date: 2022/10/9 14:18
     */
    static NormalListNode getLastModularNode(NormalListNode headNode, int k) {
        if (headNode == null) {
            return headNode;
        }
        NormalListNode modularNode = null;
        int i = 1;
        while (headNode != null) {
            if (i % k == 0 ) {
                modularNode = headNode;
            }
            headNode = headNode.getNext();
            i++;
        }
        return modularNode;
    }

    public static void main(String[] args) {
        NormalListNode headNode = initList();
        int k = 3;
        headNode = getLastModularNode(headNode, k);
        System.out.println("The last modular node is " + (headNode == null ? "null" : headNode.getData()));
    }

    /**
     * 初始化链表
     *
     * @return org.example.linkedlist.normal.NormalListNode
     * @author: Max Solider
     * @date: 2022/10/7 10:44
     */
    static NormalListNode initList() {
        NormalListNode head = new NormalListNode(1);
        NormalListNode cur = head;
        for (int i = 1; i < 20; i++) {
            cur.setNext(new NormalListNode(i + 1));
            cur = cur.getNext();
        }
        return head;
    }

}
