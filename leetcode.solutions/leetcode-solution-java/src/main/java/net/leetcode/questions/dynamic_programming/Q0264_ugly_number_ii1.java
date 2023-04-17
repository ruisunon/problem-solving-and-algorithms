package net.leetcode.questions.dynamic_programming;

public class Q0264_ugly_number_ii1 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = min3(dp[index2] * 2, dp[index3] * 3, dp[index5] * 5);

            if (dp[i] == dp[index2] * 2) {
                index2++;
            }
            if (dp[i] == dp[index3] * 3) {
                index3++;
            }
            if (dp[i] == dp[index5] * 5) {
                index5++;
            }
        }
        return dp[n - 1];
    }

    private int min3(int num1, int num2, int num3) {
        return Integer.min(Integer.min(num1, num2), num3);
    }
}
