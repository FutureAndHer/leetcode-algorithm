package org.example.stack;

/**
 * getMinimum()操作的时间复杂度为O(1)的栈
 *
 * @className: AdvancedStack
 * @author: Max Solider
 * @date: 2023-06-08 22:19
 */
public class AdvancedStack {

    /**
     * 原栈
     */
    private LLStack oStack = new LLStack();

    /**
     * 最小栈
     */
    private LLStack mStack = new LLStack();

    /**
     * 入栈操作(只有新入栈元素比栈内最小元素还小时，才在minStack中入栈)
     * @param data 待入栈元素
     */
    public void push(int data) {
        oStack.push(String.valueOf(data));
        if (mStack.isEmpty() || data < Integer.parseInt(mStack.top())) {
            mStack.push(String.valueOf(data));
        }
    }

    /**
     * 出栈元素(只有原栈顶元素和最小栈顶元素相等时，minStack中元素才出栈)
     */
    public String pop() {
        String data = oStack.pop();
        if (data.equals(mStack.top())) {
            mStack.pop();
        }
        return data;
    }

    /**
     * 获取栈中最小的元素
     * @return 栈中最小的元素
     */
    public String getMin() {
        return mStack.top();
    }

    public static void main(String[] args) {
        AdvancedStack stack = new AdvancedStack();
        stack.push(2);
        stack.push(6);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        System.out.println("The min data in stack is " + stack.getMin());
        stack.pop();
        System.out.println("The min data in stack is " + stack.getMin());
        stack.pop();
        System.out.println("The min data in stack is " + stack.getMin());
        stack.pop();
        System.out.println("The min data in stack is " + stack.getMin());
    }
}
