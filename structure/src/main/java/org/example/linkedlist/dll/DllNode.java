package org.example.linkedlist.dll;

/**
 * 双向链表元素结点数据结构
 *
 * @className: DllNode
 * @author: Max Solider
 * @date: 2022-10-08 17:02
 */
public class DllNode {

    /**
     * 结点数据
     */
    private int data;

    /**
     * 前驱结点
     */
    private DllNode previous;

    /**
     * 后继结点
     */
    private DllNode next;

    public DllNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DllNode getPrevious() {
        return previous;
    }

    public void setPrevious(DllNode previous) {
        this.previous = previous;
    }

    public DllNode getNext() {
        return next;
    }

    public void setNext(DllNode next) {
        this.next = next;
    }
}
