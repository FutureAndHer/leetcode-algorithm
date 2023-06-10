package org.example.stack;

/**
 * 栈元素排序
 *
 * @className: StackSorter
 * @author: Max Solider
 * @date: 2023-06-09 08:32
 */
public class StackSorter {

    public static LLStack sort(LLStack s) {
        LLStack r = new LLStack();
        while (!s.isEmpty()) {
            if (r.isEmpty()) {
                r.push(s.pop());
            }
            String temp = s.pop();
            while (!r.isEmpty() && Integer.valueOf(r.top()) < Integer.valueOf(temp)) {
                s.push(r.pop());
            }
            r.push(temp);
        }
        return r;
    }

    public static void main(String[] args) {
        LLStack stack = new LLStack();
        stack.push("2");
        stack.push("6");
        stack.push("4");
        stack.push("1");
        stack.push("5");
        stack = sort(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
