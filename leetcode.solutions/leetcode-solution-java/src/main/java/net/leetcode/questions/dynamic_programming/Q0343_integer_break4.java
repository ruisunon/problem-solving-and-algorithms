package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0343_integer_break4 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        // 接下来就是 n >= 5 的时候的逻辑了
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    public static void main(String[] args) {
        Q0343_integer_break4 solution2 = new Q0343_integer_break4();
        int integerBreak = solution2.integerBreak(8);
        System.out.println(integerBreak);
    }

  public static class Q0343_integerBreak8 {

      private int[] memo;

      /**
       * 记忆化递归
       *
       * @param n
       * @return
       */
      public int integerBreak(int n) {
          memo = new int[n + 1];
          return find(n);
      }

      private int max3(int a, int b, int c) {
          return Math.max(a, Math.max(b, c));
      }

      private int find(int n) {
          if (memo[n] > 0) {
              return memo[n];
          }
          if (n == 1) {
              memo[1] = 1;
              return 1;
          }
          int maxVal = Integer.MIN_VALUE;
          for (int i = 1; i < n; i++) {
              maxVal = max3(maxVal, i * (n - i), i * find(n - i));
          }
          memo[n] = maxVal;
          return memo[n];
      }
  }

    public static class Q0343_integerBreak9 {

        // 动态规划：dp[i] 就是题目问的那种情况
        // 把状态和状态转移方程写清楚，贪心算法的证明过于复杂

        public int integerBreak(int n) {
            int[] dp = new int[n + 1];

            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
                }
            }
            return dp[n];
        }

        public static void main(String[] args) {
            int n = 10;
            Q0343_integerBreak9 solution2 = new Q0343_integerBreak9();
            int res = solution2.integerBreak(n);
            System.out.println(res);
        }
    }

    public static class Q0343_integerBreak10 {

        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
                }
            }
            return dp[n];
        }
    }
}