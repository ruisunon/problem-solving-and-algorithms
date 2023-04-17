package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0343_integer_break3 {
    public int integerBreak(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = max3(max, j * (i - j), j * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Integer.max(Integer.max(num1, num2), num3);
    }

    public static void main(String[] args) {
        Q0343_integer_break3 solution = new Q0343_integer_break3();
        int integerBreak = solution.integerBreak(8);
        System.out.println(integerBreak);
    }

  public static class Q0343_integerBreak11 {

      public int integerBreak(int n) {
          // 0 需要占位，因此开 n + 1 个空间
          int[] dp = new int[n + 1];
          // 这个值不会被参考到，因此，只是占位，不会被用到
          dp[0] = 99999;
          dp[1] = 1;
          dp[2] = 1;
          for (int i = 3; i <= n; i++) {
              for (int j = 1; j < i; j++) {
                  dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
              }
          }
          return dp[n];
      }
  }
}