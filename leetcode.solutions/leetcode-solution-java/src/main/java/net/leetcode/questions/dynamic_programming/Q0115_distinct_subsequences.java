package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0115_distinct_subsequences {

    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i < slen + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < slen + 1; i++) {
            for (int j = 1; j < tlen + 1 && j <= i; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
//        for (int i = 0; i < slen + 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[slen][tlen];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Q0027_remove_element solution = new Q0027_remove_element();
        int numDistinct = solution.numDistinct(s, t);
        System.out.println(numDistinct);
    }
}