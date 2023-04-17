package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0377_combination_sum_iv {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    dp[i + num] += dp[i];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] nums = {1, 2, 3};
        int target = 4;
        int res = solution.combinationSum4(nums, target);
        System.out.println(res);
    }
}
