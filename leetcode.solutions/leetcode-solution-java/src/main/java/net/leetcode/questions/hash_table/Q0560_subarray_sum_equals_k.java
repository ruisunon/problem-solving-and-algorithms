package net.leetcode.questions.hash_table;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0560_subarray_sum_equals_k {

    // 暴力解法：枚举左右边界（超时）
    // 时间复杂度：O(N^3)

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, -1, 1, -1, 1};
        int k = 3;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
