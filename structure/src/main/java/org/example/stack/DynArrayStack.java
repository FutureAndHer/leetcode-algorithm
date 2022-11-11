package org.example.stack;

/**
 * 动态数组实现栈
 *
 * @className: DynArrayStack
 * @author: Max Solider
 * @date: 2022-11-11 11:40
 */
public class DynArrayStack {

    /**
     * 栈顶元素下标
     */
    private int top;

    /**
     * 栈容量
     */
    private int capacity;

    /**
     * 用于存放栈元素的数组
     */
    private int[] array;

    public DynArrayStack() {
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    /**
     * 栈内是否没有数据
     *
     * @return true：没有数据；false：有数据
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 栈内数据是否已存满
     *
     * @return true：已存满；false：未存满
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * 插入元素
     *
     * @param data 待插入元素
     */
    public void push(int data) {
        if (isFull()) {
            doubleStack();
        }
        top++;
        array[top] = data;
    }

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Overflow.");
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

    /**
     * 数组倍增
     */
    private void doubleStack() {
        int newArray[] = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity * 2;
        array = newArray;
    }
}
