package org.example.array;

/**
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @className: FindInArray
 * @author: Max Solider
 * @date: 2023-07-05 07:44
 */
public class FindInArray {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(15, array));
    }

    private static boolean find(int target, int[][] array) {
        // 入参合法性校验
        if (array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        // 由于数组每一行、每一列都是按顺序递增排列，所以可以从左下角（必须得有一个方向是从大到小，一个方向是从小到大）开始，
        // 依次判断上一行元素、下一列元素与目标值的关系，
        // 如果当前值大于目标值，则往上查找，若当前值小于目标值，则向右查找
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (target == array[i][j]) {
                return true;
            }
            if (target > array[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
