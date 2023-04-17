package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0053_maximum_subarray3 {

    // 动态规划

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 最后不要忘记全部看一遍求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        int maxSubArray = solution4.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}
