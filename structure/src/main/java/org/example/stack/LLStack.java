package org.example.stack;

/**
 * 链表实现栈
 *
 * @className: LLStack
 * @author: Max Solider
 * @date: 2022-11-11 11:40
 */
public class LLStack {

    private LLNode headNode;

    public LLStack() {
    }

    /**
     * 栈内是否没有数据
     *
     * @return true：没有数据；false：有数据
     */
    public boolean isEmpty() {
        return headNode == null;
    }

    /**
     * 栈内数据是否已存满
     *
     * @return true：已存满；false：未存满
     */
    public boolean isFull() {
        return false;
    }

    /**
     * 插入元素
     *
     * @param data 待插入元素
     */
    public void push(int data) {
        if (headNode == null) {
            headNode = new LLNode(data);
            return;
        }
        LLNode newHead = new LLNode(data);
        newHead.setNext(headNode);
        headNode = newHead;
    }

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty.");
            return 0;
        }
        int result = headNode.getData();
        headNode = headNode.getNext();
        return result;
    }

    /**
     * 删除栈
     */
    public void deleteStack() {
        headNode = null;
    }

    /**
     * 链表结点
     */
    private class LLNode {

        /**
         * 结点元素
         */
        private int data;

        /**
         * 后继指针
         */
        private LLNode next;

        public LLNode(int data) {
            this.data = data;
        }

        public LLNode getNext() {
            return next;
        }

        public void setNext(LLNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
