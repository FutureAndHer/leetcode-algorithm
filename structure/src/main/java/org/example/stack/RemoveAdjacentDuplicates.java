package org.example.stack;

/**
 * 删除栈中重复的数字
 *
 * @className: RemoveAdjacentDuplicates
 * @author: Max Solider
 * @date: 2023-06-10 09:04
 */
public class RemoveAdjacentDuplicates {
    public static int removeAdjacentDuplicates(int[] array) {
        int stkptr = -1;
        int i = 0;
        while (i < array.length) {
            if (stkptr == -1 || array[stkptr] != array[i]) {
                stkptr++;
                array[stkptr] = array[i];
                i++;
            } else {
                while (i < array.length && array[stkptr] == array[i]) {
                    i++;
                }
                stkptr--;
            }
        }
        return stkptr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 3, 3, 2, 5,4, 4, 5};
        int ptr = removeAdjacentDuplicates(array);
        for (int i = 0; i <= ptr; i++) {
            System.out.println(array[i]);
        }
    }
}
