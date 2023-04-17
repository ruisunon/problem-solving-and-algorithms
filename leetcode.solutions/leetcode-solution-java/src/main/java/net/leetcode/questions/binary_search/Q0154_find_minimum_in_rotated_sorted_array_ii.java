package net.leetcode.questions.binary_search;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0154_find_minimum_in_rotated_sorted_array_ii {

    public int findMin(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                assert nums[mid] == nums[right];
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Q0027_remove_element solution = new Q0027_remove_element();
        int solutionMin = solution.findMin(nums);
        System.out.println(solutionMin);
    }
}