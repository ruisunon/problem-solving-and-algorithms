package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    // 排序是前提：按照字符串的长度排序
    // 与 第 300 题很像的地方在于：当前的状态值和之前所有的状态相关
    // 这里 dp 以 hash 表的性质存在
    // 时间复杂度: O(N \log N + N * maxLenOfWord)，这里 N 是字符串数组的长度。排序 + 双重遍历

    public int longestStrChain(String[] words) {
        int len = words.length;
        // key：字符串，value：以该字符串为结尾的链的长度
        Map<String, Integer> dp = new HashMap<>(len);

        // 前提：排序
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            int maxLen = 0;

            int currentWordLen = word.length();
            for (int i = 0; i < currentWordLen; i++) {
                // 枚举所有的比当前字符串少了一个字符的子串
                String prev = word.substring(0, i) + word.substring(i + 1);
                maxLen = Math.max(maxLen, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, maxLen);
        }

        // 这里和「最长上升子序列」一样，要遍历一次，输出最长的长度
        int res = 0;
        for (int value:dp.values() ) {
            res = Math.max(res, value);
        }
        return res;
    }

  public static class wiggleMaxLength1 {

      // dp[i]：代表以 i 结尾能取到的最长摆动序列的长度
      // 取 dp[i][0] 代表以 i 为结尾且 i - 1 到 i 为升
      // dp[i][1] 代表以 i 为结尾且 i - 1 到 i 为降

      // 如果当前 nums[i] 严格大于 nums[j]，则可以取从 j 到 i 上升，因此可以取 dp[j][i] + 1，
      //  因为 j 需要与之前的值是下降关系所以取的是 dp[j][1]

      // dp[i][0] = Math.max(if(nums[i] > nums[j]) dp[j][1] + 1), j:[0, i - 1]
      // dp[i][1] = Math.max(if(nums[i] < nums[j]) dp[j][0] + 1), j:[0, i - 1]

      public int wiggleMaxLength(int[] nums) {
          int len = nums.length;
          if (len < 2) {
              return len;
          }

          int[][] dp = new int[len][2];
          dp[0][0] = 1;
          dp[0][1] = 1;

          for (int i = 1; i < len; i++) {
              dp[i][0] = 1;
              dp[i][1] = 1;
              for (int j = 0; j < i; j++) {
                  if (nums[i] > nums[j]) {
                      dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                  } else if (nums[i] < nums[j]) {
                      dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                  }
              }
          }
          int max = 1;
          for (int i = 0; i < len; i++) {
              int nowmax = Math.max(dp[i][0], dp[i][1]);
              max = Math.max(max, nowmax);
          }
          return max;
      }

  }
}
