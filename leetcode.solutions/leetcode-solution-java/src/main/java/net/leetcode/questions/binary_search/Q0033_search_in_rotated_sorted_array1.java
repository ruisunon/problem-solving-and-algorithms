package net.leetcode.questions.binary_search;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0033_search_in_rotated_sorted_array1 {

    // 中间元素和左边界比较

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        // 注意：这里是等于
        while (left < right) {
            int mid = (left + right + 1) >>> 1;

            if (nums[mid] > nums[left]) {
                // 前有序，包括中间数
                // 1 2 6 7 8 9
                // 6 7 8 9 1 2
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                // 后有序，包括中间数
                // 8 9 1 2 6 7
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int search = solution.search(nums, target);
        System.out.println(search);
    }
}
