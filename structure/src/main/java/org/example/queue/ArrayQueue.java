package org.example.queue;

/**
 * 简单循环数组实现队列
 *
 * @className: ArrayQueue
 * @author: Max Solider
 * @date: 2023-06-10 15:07
 */
public class ArrayQueue {

    /**
     * 用于存放元素的数组
     */
    private int[] array;

    /**
     * 队首下标
     */
    private int head;

    /**
     * 队尾下标
     */
    private int tail;

    /**
     * 队列容量
     */
    private int capacity;

    /**
     * 初始化队列
     * @param size 队列大小
     */
    public ArrayQueue(int size) {
        capacity = size;
        array = new int[size];
        head = -1;
        tail = -1;
    }

    /**
     * 创建简单循环数组队列
     * @param size 队列大小
     * @return 队列
     */
    public static ArrayQueue createArrayQueue(int size) {
        return new ArrayQueue(size);
    }

    /**
     * 判断队列中是否没元素
     * @return true，false
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * 判断队列中是否已满
     * @return true，false
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    /**
     * 获取队列中元素个数
     * @return 元素个数
     */
    public int getQueueSize() {
        return (capacity - head + tail + 1) % capacity;
    }

    /**
     * 入队
     * @param data 待入队元素
     */
    public void enQueue(int data) {
        if (isFull()) {
            return;
        }
        if (head == -1) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % capacity;
        }
        array[tail] = data;
    }

    /**
     * 出队
     * @return 队首元素
     */
    public Integer deQueue() {
        if (isEmpty()) {
            return null;
        }
        int result = array[head];
        if (head == tail) {
            head = tail = -1;
        } else {
            head = (head + 1) % capacity;
        }
        return result;
    }

    public void print() {
        if (tail >= head) {
            for (int i = head; i <= tail; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = head; i < capacity; i++) {
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i <= tail; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = createArrayQueue(5);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(12);
        queue.enQueue(23);
        queue.enQueue(124);
        queue.enQueue(122);
        queue.print();

        queue.deQueue();
        queue.print();

        queue.enQueue(432);
        queue.print();
    }
}
