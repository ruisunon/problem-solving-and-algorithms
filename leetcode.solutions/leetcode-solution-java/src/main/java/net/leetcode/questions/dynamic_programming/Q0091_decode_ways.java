package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0091_decode_ways {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if nums[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(nums[i - 1..i]) <= 26
        int[] dp = new int[len];
        dp[0] = 0;

        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String s = "10";
        int res = solution.numDecodings(s);
        System.out.println(res);
    }
}
