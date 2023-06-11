package org.example.queue;

/**
 * 两个队列实现栈
 *
 * @className: StackWithTwoQueue
 * @author: Max Solider
 * @date: 2023-06-10 21:41
 */
public class StackWithTwoQueue {

    private static ArrayQueue q1 = new ArrayQueue(10);

    private static ArrayQueue q2 = new ArrayQueue(10);

    public static void push(int data) {
        if (q1.isFull() && q2.isFull()) {
            return;
        }
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.enQueue(data);
            return;
        }
        if (!q1.isEmpty()) {
            q1.enQueue(data);
            return;
        }
        if (!q2.isEmpty()) {
            q2.enQueue(data);
            return;
        }
    }

    public static Integer pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        if (q1.isEmpty()) {
            int size = q2.getQueueSize();
            for (int i = 0; i < size - 1; i++) {
                q1.enQueue(q2.deQueue());
            }
            return q2.deQueue();
        } else {
            int size = q1.getQueueSize();;
            for (int i = 0; i < size - 1; i++) {
                q2.enQueue(q1.deQueue());
            }
            return q1.deQueue();
        }
    }

    public static void main(String[] args) {
        push(1);
        push(3);
        push(2);
        push(113);
        push(5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        push(43);
        push(18);
        push(21);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
