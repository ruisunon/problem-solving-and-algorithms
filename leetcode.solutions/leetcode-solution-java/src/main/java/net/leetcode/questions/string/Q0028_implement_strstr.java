package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0028_implement_strstr {

    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (hlen == 0) {
            return -1;
        }
        if (nlen == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String haystack = "hello";
        String needle = "ll";
        int strStr = solution.strStr(haystack, needle);
        System.out.println(strStr);
    }
}
