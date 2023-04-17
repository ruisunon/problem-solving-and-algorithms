package net.leetcode.questions.hash_table;

import java.util.Arrays;

public class Q1371_find_the_longest_substring_containing_vowels_in_even_counts1 {

    public int findTheLongestSubstring(String s) {
        int[] dp = new int[32];
        Arrays.fill(dp, -1);

        int bitMap = 0;
        dp[bitMap] = 0;

        int res = 0;
        int index = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            index++;
            if (c == 'a') {
                bitMap ^= 1;
            }
            if (c == 'e') {
                bitMap ^= (1 << 1);
            }
            if (c == 'i') {
                bitMap ^= (1 << 2);
            }
            if (c == 'o') {
                bitMap ^= (1 << 3);
            }
            if (c == 'u') {
                bitMap ^= (1 << 4);
            }

            if (dp[bitMap] >= 0) {
                // 由于此时 index 已经 ++，因此是 index - dp[bitMap]
                res = Math.max(res, index - dp[bitMap]);
            } else {
                dp[bitMap] = index;
            }
        }
        return res;
    }
}
