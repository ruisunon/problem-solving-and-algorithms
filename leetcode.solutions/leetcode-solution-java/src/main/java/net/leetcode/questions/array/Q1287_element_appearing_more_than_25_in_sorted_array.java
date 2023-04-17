package net.leetcode.questions.array;

public class Q1287_element_appearing_more_than_25_in_sorted_array {

    public int findSpecialInteger(int[] arr) {
        int[] count = new int[10_0000];
        int len = arr.length;
        double threshold = len * 0.25;

        for (int num : arr) {
            count[num]++;
            if (count[num] > threshold) {
                return num;
            }
        }
        throw new IllegalArgumentException("输入出错！");
    }
}
