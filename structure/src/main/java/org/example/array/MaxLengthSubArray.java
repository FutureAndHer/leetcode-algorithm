package org.example.array;

import java.util.HashMap;

/**
 * 最长无重复子数组
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 示例 输入：[2,3,4,5] 返回值：4  说明：[2,3,4,5]是最长子数组
 * 输入：[2,2,3,4,3] 返回值：3 说明：[2,3,4]是最长子数组
 * 输入：[2,2,3,4,8,99,3] 返回值：5 说明：最长子数组为[2,3,4,8,99]
 *
 * @className: MaxLengthSubArray
 * @author: Max Solider
 * @date: 2023-07-05 22:10
 */
public class MaxLengthSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3, 2};
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] arr) {
        // 1. 入参合法性校验
        if (arr == null) {
            return 0;
        }
        if (arr.length <= 1) {
            return arr.length;
        }
        // 2. 用双指针right和left，遍历数组，并用hash表存下出现过的元素和其下标。
        //      当未遇见重复元素时，只移动right指针，并累计子数组长度，并将长度与最大子数组长度作对比，若大于最大子数组长度，则更新数据
        //      当遇见重复元素时，找到第一次出现元素的下标，和left指针当前下标作对比，取最大值+1作为left指针新下标
        int left = 0;
        int maxSubLength = 0;
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        for (int right = 0; right < arr.length; right++) {
            if (elements.containsKey(arr[right])) {
                left = Math.max(left, elements.get(arr[right]) + 1);
            }
            maxSubLength = Math.max(right - left + 1, maxSubLength);
            elements.put(arr[right], right);
        }
        return maxSubLength;
    }


}
