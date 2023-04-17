package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0014_longest_common_prefix {

    // 参考资料：https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51379541

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        // 根据题意，最长不会超过字符串数组的第 1 个字符串的长度
        int maxLen = strs[0].length();
        for (int cnt = 0; cnt < maxLen; cnt++) {
            // 从下标为 1 的字符串开始比较就行
            for (int i = 1; i < len; i++) {
                if (cnt == strs[i].length() || strs[0].charAt(cnt) != strs[i].charAt(cnt)) {
                    return strs[0].substring(0, cnt);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        Q0027_remove_element solution = new Q0027_remove_element();
        String longestCommonPrefix = solution.longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }
}
