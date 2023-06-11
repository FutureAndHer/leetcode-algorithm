package org.example.queue;

import org.example.stack.LLStack;

/**
 * 逆置队列中前k个元素
 *
 * @className: ReverseQueueFirstKElements
 * @author: Max Solider
 * @date: 2023-06-11 09:40
 */
public class ReverseQueueFirstKElements {

    public static void reverseQueueFirstKElements(int k, ArrayQueue queue, int size) {
        if (queue.isEmpty() || size < k) {
            return;
        }
        LLStack stack = new LLStack();
        for (int i = 0; i < k; i++) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        while (!stack.isEmpty()) {
            queue.enQueue(Integer.valueOf(stack.pop()));
        }
        for (int i = 0; i < size - k; i++) {
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
        reverseQueueFirstKElements(4, queue, 8);
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
