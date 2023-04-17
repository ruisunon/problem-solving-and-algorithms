package net.leetcode.questions.dynamic_programming;

public class Q0377_combination_sum_iv3 {

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
