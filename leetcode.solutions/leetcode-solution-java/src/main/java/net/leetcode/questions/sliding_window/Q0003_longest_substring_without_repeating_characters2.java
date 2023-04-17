package net.leetcode.questions.sliding_window;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0003_longest_substring_without_repeating_characters2 {

    // 最基本的滑动窗口

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // 描述 [left, right) 里是否有元素的变量
        int[] freq = new int[128];
        // [left, right) 无重复的元素
        int res = 1;
        for (int left = 0, right = 0; right < len; right++) {
            freq[charArray[right]]++;

            if (freq[charArray[right]] == 2) {
                while (freq[charArray[right]] == 2) {
                    freq[charArray[left]]--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int res = solution3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
