package org.example.linkedlist.normal;

/**
 * 普通单向链表 数据结点
 *
 * @className: NormalListNode
 * @author: Max Solider
 * @date: 2022-10-08 00:02
 */
public class NormalListNode {

    /**
     * 结点数据
     */
    private int data;

    /**
     * 下一个结点
     */
    private NormalListNode next;

    public NormalListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NormalListNode getNext() {
        return next;
    }

    public void setNext(NormalListNode next) {
        this.next = next;
    }
}