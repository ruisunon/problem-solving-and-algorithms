package net.leetcode.questions.dynamic_programming;

public class Q0377_combination_sum_iv5 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这个值被其它状态参考，设置为 1 是合理的
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
        int[] nums = {1, 2, 3};
        int target = 4;
        Q0399_evaluate_division6 solution5 = new Q0399_evaluate_division6();
        int res = solution5.combinationSum4(nums, target);
        System.out.println(res);
    }
}
