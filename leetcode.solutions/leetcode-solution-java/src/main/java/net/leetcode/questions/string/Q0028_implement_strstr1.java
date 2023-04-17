package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * @author liwei
 * @date 18/6/28 下午1:33
 */
public class Q0028_implement_strstr1 {

    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (nlen == 0) {
            return 0;
        }
        for (int i = 0; i <= hlen - nlen; i++) {
            if (needle.equals(haystack.substring(i, i + nlen))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        String haystack = "a";
        String needle = "a";
        int strStr = solution2.strStr(haystack, needle);
        System.out.println(strStr);
    }
}
