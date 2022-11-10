package org.example.stack;

/**
 * 简单数组实现栈
 *
 * @className: ArrayStack 简单数组实现栈
 * @author: Max Solider
 * @date: 2022-11-10 15:50
 */
public class ArrayStack {

    /**
     * 栈顶元素下标
     */
    private int top;

    /**
     * 栈容量
     */
    private int capacity;

    /**
     * 用于存储栈元素
     */
    private int[] array;

    public ArrayStack() {
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    /**
     * 栈中是否没有元素
     *
     * @return false：有元素，true：无元素
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 栈中是否已存满元素
     *
     * @return false：未存满，true：已存满
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * 向栈中插入元素
     *
     * @param data 待插入元素
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow.");
            return;
        }
        top++;
        array[top] = data;
        System.out.println("Stack push success.");
    }

    /**
     * 取出栈顶元素，并从栈中删除
     *
     * @return 栈顶元素
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return 0;
        }
        int result = array[top];
        top--;
        return result;
    }

    /**
     * 删除栈
     */
    public void deleteStack() {
        top = -1;
    }
}
