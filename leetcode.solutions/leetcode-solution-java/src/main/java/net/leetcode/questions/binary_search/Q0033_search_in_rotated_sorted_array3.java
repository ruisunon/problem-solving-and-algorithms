package net.leetcode.questions.binary_search;

public class Q0033_search_in_rotated_sorted_array3 {

    // 最朴素的解法，时间复杂度不符合要求

    public int search(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
