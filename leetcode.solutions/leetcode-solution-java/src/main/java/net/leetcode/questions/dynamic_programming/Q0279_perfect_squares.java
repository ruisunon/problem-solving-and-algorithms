package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

class Q0279_perfect_squares {

    // 说明 dp[0] = 0; 的合理性
    // 表达式 1 + dp[i - j * j] = 1 ，表示它自己就是一个完全平方式，所以结果是 1

    public int numSquares(int n) {
        // 0 要占用一个位置
        int[] dp = new int[n + 1];

        // 赋初值，设置成为 4 是数学定理保证
        Arrays.fill(dp, 4);
        // 该值被参考，设置成 0
        dp[0] = 0;

        // 一个一个求，自底向上
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k * k <= i; k++) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7168;
        Q0027_remove_element solution = new Q0027_remove_element();
        int numSquares = solution.numSquares(n);
        System.out.println(numSquares);
    }
}