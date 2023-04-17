package net.leetcode.questions.sliding_window;

import java.util.HashMap;
import java.util.Map;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0003_longest_substring_without_repeating_characters {

    // 哈希表，最优解

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }

        int res = 1;
        // key：数值，value：最新的下标
        Map<Character, Integer> map = new HashMap<>(len);
        char[] charArray = s.toCharArray();

        int left = 0;
        int right = 0;
        // [left, right) 没有重复元素
        while (right < len) {
            Character c = charArray[right];
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;

            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        String s = "dvdf";
        Q0027_remove_element solution = new Q0027_remove_element();
        int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}