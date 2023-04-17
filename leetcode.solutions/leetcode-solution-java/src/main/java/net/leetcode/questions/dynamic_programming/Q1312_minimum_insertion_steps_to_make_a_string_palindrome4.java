package net.leetcode.questions.dynamic_programming;

public class Q1312_minimum_insertion_steps_to_make_a_string_palindrome4 {

    public int minInsertions(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];
        for (int j = 1; j < len; j++) {

            // 注意顺序，之后的值一定会被之前参考到
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    if (j - i < 2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }

//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Q0399_evaluate_division5 solution = new Q0399_evaluate_division5();
        // String s = "mbadm";
        // String s = "zzazz";
        // String s = "leetcode";
        String s = "g";
        int res = solution.minInsertions(s);
        System.out.println(res);
    }
}
