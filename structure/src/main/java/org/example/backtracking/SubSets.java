package org.example.backtracking;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合的所有子集
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 给出的子集元素必须按升序排列，且子集中不能出现重复元素
 *
 * @className: SubSets
 * @author: Max Solider
 * @date: 2023-07-04 23:47
 */
public class SubSets {

    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = subsets(s);
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // 1.校验入参合法性
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length <= 0) {
            return result;
        }
        // 2. 因为最后自己需要有序排列，先对原始数组进行排序
        Arrays.sort(S);
        // 3.按照子集元素个数划分，子集可能会有1,2,...,S.length个元素. 按照元素个数来构造子集
        for (int i = 0; i <= S.length; i++) {
            recursion(S, i, 0, new ArrayList<Integer>(), result);
        }
        return result;
    }

    private static void recursion(int[] s, int count, int startIndex, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result) {
        // 子集中元素个数不能超过限定数量
        if (sub.size() >= count) {
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        // 从start下标开始遍历原始数组，每个元素有放入子集和不放入子集两种选择
        for (int i = startIndex; i < s.length; i++) {
            // 元素放入子集，继续递归查找子集剩余元素
            sub.add(s[i]);
            recursion(s, count, i + 1, sub, result);
            // 跳过此元素，继续查找子集剩余元素
            sub.remove(sub.size() - 1);
        }
    }
}
