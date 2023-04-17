package net.leetcode.questions.binary_search;

public class Q0153_find_minimum_in_rotated_sorted_array5 {

    // 暴力法

    public int findMin(int[] nums) {
        int len = nums.length;
        int minVal = nums[0];
        for (int i = 1; i < len; i++) {
            minVal = Math.min(minVal, nums[i]);
        }
        return minVal;
    }
}
