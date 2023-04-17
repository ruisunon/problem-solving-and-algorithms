package net.leetcode.questions.dynamic_programming;

public class Q0198_house_robber {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i]：子区间 [0, i] 在不触动警报装置的情况下，能够偷窃到的最高金额
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            // 分类讨论：在偷 nums[i] 与不偷 nums[i] 中选择一个最大值
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
}
