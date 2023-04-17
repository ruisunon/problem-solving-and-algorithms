package net.leetcode.questions.dynamic_programming;

import java.util.*;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * Created by gouthamvidyapradhan on 05/05/2019 You have a number of envelopes with widths and
 * heights given as a pair of integers (w, h). One envelope can fit into another if and only if both
 * the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * <p>What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * <p>Note: Rotation is not allowed.
 *
 * <p>Example:
 *
 * <p>Input: [[5,4],[6,4],[6,7],[2,3]] Output: 3 Explanation: The maximum number of envelopes you
 * can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * <p>Q0169_majority_element: O(N ^ 2) Sort the envelopes based on increasing order of area and for each envelope
 * iterate through all the possible envelopes which are smaller than that the current envelope and
 * check the maximum possible envelopes which an be russian dolled.
 */
public class RussianDollEnvelopes {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] A = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    System.out.println(new RussianDollEnvelopes().maxEnvelopes(A));
  }

  class Envelope {
    int l, b;

    Envelope(int l, int b) {
      this.l = l;
      this.b = b;
    }
  }
  /**
   * @param envelopes
   * @return
   */
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length == 0) return 0;
    List<Envelope> list = new ArrayList<>();
    for (int[] row : envelopes) {
      list.add(new Envelope(row[0], row[1]));
    }
    list.sort(((o1, o2) -> Integer.compare(o2.l * o2.b, o1.l * o1.b)));
    int[] DP = new int[envelopes.length];
    Arrays.fill(DP, 1);
    for (int i = list.size() - 1; i >= 0; i--) {
      Envelope env = list.get(i);
      for (int j = i + 1, l = list.size(); j < l; j++) {
        Envelope childEnv = list.get(j);
        if (env.l > childEnv.l && env.b > childEnv.b) {
          DP[i] = Math.max(DP[i], DP[j] + 1);
        }
      }
    }
    int ans = 1;
    for (int i : DP) {
      ans = Math.max(ans, i);
    }
    return ans;
  }

  public static class wiggleMaxLength3 {

      // 动态规划
      // 思路：结尾的那个数字很重要
      // 注意：摆动序列的最长子序列的长度

      // dp[i][0] 表示以 i 结尾的数字是严格上升的
      // dp[i][1] 表示以 i 结尾的数字是严格下降的

      // 状态转移方程：只看结尾和前一个数的关系
      // 初始化：dp[0][0] = 1，dp[0][1] = 1

      // 这是比较容易想到的
      // dp[i][0] = dp[i - 1][1] + 1, if nums[i] - nums[i - 1] > 0
      // dp[i][1] = dp[i - 1][0] + 1, if nums[i] - nums[i - 1] < 0

      // 分析到这里，知道需要分类讨论

      // 输出：拉通看最大值

      public int wiggleMaxLength(int[] nums) {
          int len = nums.length;
          if (len < 2) {
              return len;
          }

          int[] dp = new int[2];
          dp[0] = 1;
          dp[1] = 1;

          for (int i = 1; i < len; i++) {
              if (nums[i - 1] < nums[i]) {
                  // 结尾时候的状态是严格上升的
                  dp[0] = dp[1] + 1;
              } else if (nums[i - 1] > nums[i]) {
                  // 结尾时候的状态是严格下降的
                  dp[1] = dp[0] + 1;
              }
          }
          return Math.max(dp[0], dp[1]);
      }

      public static void main(String[] args) {
          // int[] nums = {1, 7, 4, 9, 2, 5};
          int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        wiggleMaxLength3 solution3 = new wiggleMaxLength3();
          int res = solution3.wiggleMaxLength(nums);
          System.out.println(res);
      }
  }
}
