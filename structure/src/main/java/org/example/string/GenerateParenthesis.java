package org.example.string;

import java.util.ArrayList;

/**
 * 括号生成
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为： "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * @className: GenerateParenthesis
 * @author: Max Solider
 * @date: 2023-07-04 23:26
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        ArrayList<String> result = generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        recursion(0, 0, "", result, n);
        return result;
    }

    private static void recursion(int leftCount, int rightCount, String tmp, ArrayList<String> result, int n) {
        if (leftCount >= n && rightCount >= n) {
            result.add(tmp);
            return;
        }
        if (leftCount < n) {
            recursion(leftCount + 1, rightCount, tmp + "(", result, n);
        }
        if (rightCount < n && leftCount > rightCount) {
            recursion(leftCount, rightCount + 1, tmp + ")", result, n);
        }
    }
}
