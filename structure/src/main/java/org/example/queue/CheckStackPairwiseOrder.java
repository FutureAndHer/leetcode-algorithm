package org.example.queue;

import org.example.stack.LLStack;

/**
 * 检查整数占中每对相邻数字是否连续
 *
 * @className: CheckStackPairwiseOrder
 * @author: Max Solider
 * @date: 2023-06-10 22:32
 */
public class CheckStackPairwiseOrder {

    public static boolean checkStackPairwiseOrder(LLStack stack) {
        if (stack.isEmpty()) {
            return true;
        }
        ArrayQueue queue = new ArrayQueue(20);
        while (!stack.isEmpty()) {
            queue.enQueue(Integer.valueOf(stack.pop()));
        }
        while (!queue.isEmpty()) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        boolean result = true;
        while (!stack.isEmpty()) {
            int n = Integer.valueOf(stack.pop());
            queue.enQueue(n);
            if (!stack.isEmpty()) {
                int m = Integer.valueOf(stack.pop());
                queue.enQueue(m);
                if ((m - n != 1) && (n - m != 1)) {
                    result = false;
                }
            }
        }
        while (!queue.isEmpty()) {
            stack.push(String.valueOf(queue.deQueue()));
        }
        return result;
    }

    public static void main(String[] args) {
        LLStack stack = new LLStack();
        stack.push("4");
        stack.push("5");
        stack.push("-2");
        stack.push("-3");
        stack.push("11");
        stack.push("10");
        stack.push("5");
        stack.push("6");
        stack.push("20");
        System.out.println(checkStackPairwiseOrder(stack));
        System.out.println(stack);
    }
}
