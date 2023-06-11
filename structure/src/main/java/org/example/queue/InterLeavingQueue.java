package org.example.queue;

import org.example.stack.LLStack;

/**
 * 交叉排列队列中的元素
 *
 * @className: InterLeavingQueue
 * @author: Max Solider
 * @date: 2023-06-10 22:55
 */
public class InterLeavingQueue {

    public static void interLeavingQueue(int size, ArrayQueue queue) {
        if (queue.isEmpty()) {
            return;
        }
        LLStack stack = new LLStack();
        for (int i = 0; i < size / 2; i++) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        while (!stack.isEmpty()) {
            queue.enQueue(Integer.valueOf(stack.pop()));
        }
        for (int i = 0; i < size / 2; i++) {
            queue.enQueue(queue.deQueue());
        }
        for (int i = 0; i < size / 2; i++) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        while (!stack.isEmpty()) {
            queue.enQueue(Integer.valueOf(stack.pop()));
            queue.enQueue(queue.deQueue());
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        interLeavingQueue(8, queue);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
