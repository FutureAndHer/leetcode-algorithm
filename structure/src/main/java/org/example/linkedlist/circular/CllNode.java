package org.example.linkedlist.circular;

/**
 * 循环链表结点
 *
 * @className: CllNode
 * @author: Max Solider
 * @date: 2022-10-08 21:48
 */
public class CllNode {

    /**
     * 结点数据
     */
    private int data;

    /**
     * 后继结点指针
     */
    private CllNode next;

    public CllNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CllNode getNext() {
        return next;
    }

    public void setNext(CllNode next) {
        this.next = next;
    }
}
