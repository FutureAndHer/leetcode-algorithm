package org.example.queue;

import org.example.stack.LLStack;

/**
 * 用两个栈实现队列
 *
 * @className: QueueWithTwoStacks
 * @author: Max Solider
 * @date: 2023-06-10 21:29
 */
public class QueueWithTwoStacks {

    private static LLStack s1 = new LLStack();

    private static LLStack s2 = new LLStack();

    public static void enQueue(int data) {
        if (s1.isFull()) {
            return;
        }
        s1.push(String.valueOf(data));
    }

    public static String deQueue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return "";
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        System.out.println(deQueue());
        enQueue(3);
        enQueue(13);
        System.out.println(deQueue());
        enQueue(2);
        enQueue(5);
        System.out.println(deQueue());
        enQueue(4);
        enQueue(15);
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
    }
}