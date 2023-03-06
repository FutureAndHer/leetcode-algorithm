package org.example.stack;

import java.util.*;

/**
 * 判定括号是否匹配
 *
 * @className: SymbolMatching
 * @author: Max Solider
 * @date: 2023-03-06 22:50
 */
public class SymbolMatching {

    // 1.分别维护开、闭分隔符，以及他们之间匹配关系
    final static List<String> openSymbolList = new ArrayList<String>() {
        {
            add("(");
            add("{");
            add("[");
        }
    };
    final static List<String> closeSymbolList = new ArrayList<String>() {
        {
            add(")");
            add("}");
            add("]");
        }
    };
    final static Map<String, String> symbolMap = new HashMap<String, String>() {
        {
            put(")", "(");
            put("}", "{");
            put("]", "[");
        }
    };

    /**
     * 判定括号是否匹配
     * @param str 待判定字符串
     * @return 判定结果
     */
    public static boolean matchSymbol(String str) {
        // 2.创建栈
        LLStack llStack = new LLStack();
        // 3.遍历字符串
        for (char s : str.toCharArray()) {
            if (openSymbolList.contains(String.valueOf(s))) {
                llStack.push(String.valueOf(s));
            } else if (closeSymbolList.contains(String.valueOf(s))) {
                if (llStack.isEmpty()) {
                    return false;
                }
                String top = llStack.pop();
                if (!top.equals(symbolMap.get(String.valueOf(s)))) {
                    return false;
                }
            }
        }
        // 4.判断栈内是否为空，不为空则说明有字符未被匹配
        if (!llStack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "(A+B)+(C-D)";
        System.out.println("The result of matching is " + matchSymbol(str));
        str = "((A+B)+(C-D)";
        System.out.println("The result of matching is " + matchSymbol(str));
        str = "((A+B)+[C-D])";
        System.out.println("The result of matching is " + matchSymbol(str));
        str = "{(A+B)+(C-D))";
        System.out.println("The result of matching is " + matchSymbol(str));
    }
}
