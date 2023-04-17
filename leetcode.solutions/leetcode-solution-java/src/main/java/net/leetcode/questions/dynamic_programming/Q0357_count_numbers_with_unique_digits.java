package net.leetcode.questions.dynamic_programming;

public class Q0357_count_numbers_with_unique_digits {

    // 加上 dp[i - 1] 即加上之前的数字，即首位为 0 的数量；
    // 重点理解：dp[i - 1] - dp[i - 2] 表示不同的那些数字，要在这些数字后面填新的数字。
    //
    // 例如：当 i = 2时，说明之前选取的数字只有 1 位，那么我们只要与这一位不重复即可，所以其实有 9 ( = 10 - 1) 种情况
    // 比如 1，后面可以跟 0, 2, 3, 4, 5, 6, 7, 8, 9。
    // 当 i = 3时，说明之前选取的数字有 2 位，那么我们需要与 2 位不重复，
    // 所以剩余的有 8（ = 10 - 2）种（比如 12，后面可以跟 0, 3, 4, 5, 6, 7, 8, 9）。

    /**
     * 分类讨论
     * 思考状态如何转移
     *
     * @param n 整数的位数
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 一位数有 10 种：0，1，2，3，4，5，6，7，8，9
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }
}
