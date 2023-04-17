package net.leetcode.questions.array;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q1287_element_appearing_more_than_25_in_sorted_array1 {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        double threshold = len * 0.25;

        int preNum = arr[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == preNum) {
                count++;
                if (count > threshold) {
                    return arr[i];
                }
            } else {
                preNum = arr[i];
                count = 1;
            }
        }
        throw new IllegalArgumentException("输入出错！");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        Q1287_element_appearing_more_than_25_in_sorted_array1 solution2 = new Q1287_element_appearing_more_than_25_in_sorted_array1();
        int res = solution2.findSpecialInteger(arr);
        System.out.println(res);
    }
}
