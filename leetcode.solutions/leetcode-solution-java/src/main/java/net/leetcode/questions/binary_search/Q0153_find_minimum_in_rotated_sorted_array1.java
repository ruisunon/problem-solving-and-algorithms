package net.leetcode.questions.binary_search;

public class Q0153_find_minimum_in_rotated_sorted_array1 {

    public int findMin(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
