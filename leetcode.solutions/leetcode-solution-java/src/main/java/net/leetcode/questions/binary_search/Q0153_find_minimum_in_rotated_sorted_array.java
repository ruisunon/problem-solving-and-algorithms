package net.leetcode.questions.binary_search;

public class Q0153_find_minimum_in_rotated_sorted_array {

    public int findMin(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间在 [left, mid]
                right = mid;
            }
        }
        // 非空数组一定存在最小值
        return nums[left];
    }
}
