package org.example.queue;

import org.example.stack.LLStack;

/**
 * 逆置栈中元素
 *
 * @className: QueueReversal
 * @author: Max Solider
 * @date: 2023-06-10 21:19
 */
public class QueueReversal {

    public static ArrayQueue reversal(ArrayQueue queue) {
        LLStack stack = new LLStack();
        while (!queue.isEmpty()) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        while (!stack.isEmpty()) {
            queue.enQueue(Integer.valueOf(stack.pop()));
        }
        return queue;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enQueue(2);
        queue.enQueue(1);
        queue.enQueue(3);
        queue.enQueue(7);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(9);
        queue.print();
        queue = reversal(queue);
        queue.print();
    }
}
