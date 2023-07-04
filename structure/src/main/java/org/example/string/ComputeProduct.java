package org.example.string;

/**
 * 大数乘法
 *
 * @className: ComputeProduct
 * @author: Max Solider
 * @date: 2023-07-03 22:10
 */
public class ComputeProduct {

    public static String compute(String s, String t) {
        if (s.length() <= 0 || t.length() <= 0) {
            return "";
        }
        // 将字符串转换为int 数组
        int[] array1 = new int[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            array1[i] = s.charAt(i) - '0';
        }
        int[] array2 = new int[t.length()];
        for (int i = 0; i < t.toCharArray().length; i++) {
            array2[i] = t.charAt(i) - '0';
        }
        // 计算每一位的乘积
        int[] array3 = new int[array1.length + array2.length];
        for (int i = array1.length - 1; i >= 0; i--) {
            for (int j = array2.length - 1; j >= 0; j--) {
                array3[i + j + 1] += array1[i] * array2[j];
            }
        }
        // 若每一位的数大于等于10，则需要进位
        for (int i = array3.length - 1; i >= 0; i--) {
            if (array3[i] >= 10) {
                int tmp = array3[i];
                array3[i] = tmp % 10;
                array3[i - 1] += tmp / 10;
            }
        }
        // 将int数组转换为字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array3.length; i++) {
            // 删除首位的0
            if (result.length() == 0 && array3[i] == 0) {
                continue;
            }
            result.append(array3[i]);
        }
        // 如果结果是0，则直接返回0
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "99";
        System.out.println(compute(s1, s2));
    }
}
