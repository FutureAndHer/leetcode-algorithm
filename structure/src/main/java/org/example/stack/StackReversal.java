package org.example.stack;

/**
 * 使用栈操作逆置栈中的内容
 *
 * @className: StackReversal
 * @author: Max Solider
 * @date: 2023-06-08 23:04
 */
public class StackReversal {

    private static void reverseStack(LLStack stack) {
        if (stack.isEmpty()) {
            return;
        }
        String temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    private static void insertAtBottom(LLStack stack, String data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        String temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }


    public static void main(String[] args) {
        LLStack stack = new LLStack();
        stack.push("2");
        stack.push("6");
        stack.push("4");
        stack.push("1");
        stack.push("5");
        reverseStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
