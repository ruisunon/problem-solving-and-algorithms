package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1312_minimum_insertion_steps_to_make_a_string_palindrome {

    public int minInsertions(String s) {
        int len = s.length();

        // dp[i][j]：表示让子串成为回文的最少插入次数
        int[][] dp = new int[len][len];

        for (int span = 2; span <= len; span++) {

            for (int i = 0; i <= len - span; i++) {
                int j = i + span - 1;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String s = "mbadm";
        int res = solution.minInsertions(s);
        System.out.println(res);
    }
}
