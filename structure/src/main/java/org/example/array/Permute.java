package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 没有重复项数字的全排列
 * 给出一组数字，返回该组数字的所有排列
 * 例如： [1,2,3]的所有排列如下 [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 *
 * @className: Permute
 * @author: Max Solider
 * @date: 2023-07-05 23:14
 */
public class Permute {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = permute(array);
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // 入参合法性校验
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 1) {
            return result;
        }
        if (num.length == 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[0]);
            result.add(list);
            return result;
        }
        // 因为最后输出结果需要有序，先对数组进行排序
        Arrays.sort(num);
        // 递归遍历数组，记录新数组剩余空位，每个元素有放入和不放入两种选择，记录放入了新数组的元素在原数组的下标
        // 递归&回溯
        recursion(num, result, new ArrayList<Integer>(), new boolean[num.length]);
        return result;
    }

    private static void recursion(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> newList, boolean[] indexArray) {
        if (newList.size() == num.length) {
            result.add(new ArrayList<Integer>(newList));
            return;
        }
        // 遍历数组，找到当前还没放入新数组的元素下标
        for (int i = 0; i < num.length; i++) {
            if (!indexArray[i]) {
                // 去重
                if (i > 0 && num[i] == num[i - 1] && indexArray[i - 1]) {
                    continue;
                }
                // 放入新数组
                newList.add(num[i]);
                indexArray[i] = true;
                recursion(num, result, newList, indexArray);
                // 不放入新数组
                newList.remove(newList.size() - 1);
                indexArray[i] = false;
            }
        }
    }
}
