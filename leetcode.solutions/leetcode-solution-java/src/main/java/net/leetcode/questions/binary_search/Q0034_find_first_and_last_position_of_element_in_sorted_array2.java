package net.leetcode.questions.binary_search;

public class Q0034_find_first_and_last_position_of_element_in_sorted_array2 {

    // 帮助网友调试的程序

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return new int[]{-1, -1};
        } else {
            int a = 0;
            int b = len - 1;
            while (a < b) {
                int m = left + right + 1 >>> 1;
                if (target < nums[m]) {
                    right = m - 1;
                } else {
                    left = m;
                }
            }
            return new int[]{left, b};
        }
    }
}
