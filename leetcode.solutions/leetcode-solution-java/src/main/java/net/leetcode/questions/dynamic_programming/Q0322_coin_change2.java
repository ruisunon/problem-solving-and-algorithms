package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0322_coin_change2 {

    // 记忆化递归
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        Arrays.sort(coins);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }

            int subRes = dfs(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        Q0322_coin_change2 solution3 = new Q0322_coin_change2();
        int[] coins = {2};
        int amount = 3;
        int res = solution3.coinChange(coins, amount);
        System.out.println(res);
    }

  public static class Q0337_house_robber_iii2 {

      // 这种做法会产生很多重复子问题

      public int rob(TreeNode root) {
          if (root == null) {
              return 0;
          }
          int res = root.val;

          if (root.left != null) {
              res += rob(root.left.left) + rob(root.left.right);
          }

          if (root.right != null) {
              res += rob(root.right.left) + rob(root.right.right);
          }
          return Math.max(res, rob(root.left) + rob(root.right));
      }
  }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
