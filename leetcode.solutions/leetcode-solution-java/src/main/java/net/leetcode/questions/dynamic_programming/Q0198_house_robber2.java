package net.leetcode.questions.dynamic_programming;

public class Q0198_house_robber2 {

    public int rob(int[] nums) {
        int len = nums.length;

        // 0 表示不偷
        // 1 表示投
        // 多加 1 天表示哨兵，相应地要做一些偏移

        // dp[i]：区间 [0, i] 偷取的最大价值
        int[][] dp = new int[len + 1][2];
        for (int i = 1; i <= len; i++) {
            // 不偷由：昨天不偷，昨天偷转换而来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // 偷由：只能由昨天不偷转换来
            // 注意这里有个偏移
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }

        return Math.max(dp[len][0], dp[len][1]);
    }
}
