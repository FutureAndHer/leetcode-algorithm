package org.example.array;

/**
 * 缺失的第一个正整数
 * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 * @className: MinNumberDisappeared
 * @author: Max Solider
 * @date: 2023-07-05 08:03
 */
public class MinNumberDisappeared {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(minNumberDisappeared(nums));
    }

    private static int minNumberDisappeared(int[] nums) {
        // 入参合法性校验
        if (nums == null || nums.length <= 0) {
            return 1;
        }
        // 由于缺失的正整数只可能是1~n中某个数字，或者是n+1，恰好对应了数组的下标 0~n-1。
        // 1. 遍历数组，将所有非正整数的元素值改为n+1；
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        // 2. 遍历数组，若元素的绝对值小于等于n，则将元素值对应下标的数组元素改为负数，代表此下标对应的正整数已出现过
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length) {
                nums[Math.abs(nums[i]) - 1] = 0 - nums[Math.abs(nums[i]) - 1];
            }
        }
        // 3. 遍历数组，找到第一个出现非负数的元素下标，即第一个缺失的正整数。若未找到，说明缺失值是n+1
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result = i + 1;
                return result;
            }
        }
        if (result == 0) {
            result = nums.length + 1;
        }
        return result;
    }
}
