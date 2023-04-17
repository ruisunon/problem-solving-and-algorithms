package net.leetcode.questions.binary_search;

public class Q0154_find_minimum_in_rotated_sorted_array_ii2 {

    public int findMin(int[] nums) {
        int len = nums.length;
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (left + 1 == right) {
            return nums[left];
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid, right));
    }
}
