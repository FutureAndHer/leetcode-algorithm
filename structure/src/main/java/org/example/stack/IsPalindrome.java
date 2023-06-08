package org.example.stack;

/**
 * 判断字符串是否为回文字符串
 *
 * @className: IsPalindrome
 * @author: Max Solider
 * @date: 2023-06-08 22:45
 */
public class IsPalindrome {

    private static LLStack stack = new LLStack();

    /**
     * 判断字符串是否回文
     * @param data 字符串
     * @return 是否回文
     */
    public static boolean isPalindrome(char[] data) {
        boolean flag = false;
        for (char c : data) {
            if (c == 'X') {
               flag = true;
               continue;
            }
            if (!flag) {
                stack.push(String.valueOf(c));
            }
            if (flag) {
                if (!stack.pop().equals(String.valueOf(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] data = "ababababaXababbabaa".toCharArray();
        System.out.println("The result of isPalindrome is :" + isPalindrome(data));
        data = "ababababaXababababa".toCharArray();
        System.out.println("The result of isPalindrome is :" + isPalindrome(data));
    }
}
