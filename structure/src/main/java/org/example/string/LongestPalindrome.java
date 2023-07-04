package org.example.string;

/**
 * 获取最长回文子串
 *
 * @className: LongestPalindrome
 * @author: Max Solider
 * @date: 2023-07-04 00:21
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(getLongestPalindrome(s));
        s = "abbba";
        System.out.println(getLongestPalindrome(s));
        s = "b";
        System.out.println(getLongestPalindrome(s));
    }

    // 遍历字符串，按照中心扩散的方法，向两边找回文字符串，找到后比较长度，取最大长度的回文串
    public static String getLongestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int startIndex = 0;
        int endIndex = 0;
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getLongestPalindrome(s, i, i);
            String s2 = getLongestPalindrome(s, i, i + 1);
            String tmpMaxString = s1.length() > s2.length() ? s1 : s2;
            maxString = maxString.length() > tmpMaxString.length() ? maxString : tmpMaxString;
        }
        return maxString;
    }

    private static String getLongestPalindrome(String s, int startIndex, int endIndex) {
        String result = "";
        if (startIndex == endIndex) {
            result = s.charAt(startIndex) + "";
            startIndex--;
            endIndex++;
        }
        while (startIndex >=0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)) {
            result = s.charAt(startIndex) + result + s.charAt(endIndex);
            startIndex--;
            endIndex++;
        }
        return result;
    }

}
