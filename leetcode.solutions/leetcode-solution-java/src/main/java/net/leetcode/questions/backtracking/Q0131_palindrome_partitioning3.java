package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0131_palindrome_partitioning3 {

    // 判断是否回文
    private boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        // 01210 5 2
        // 012210 6 3
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private List<String> arrConvertList(String str) {
        List<String> res = new ArrayList<>();
        Collections.addAll(res, str.split(","));
        return res;
    }

    private void findReverse(String s, int begin, String pre, List<List<String>> res) {
        if (begin == s.length()) {
            res.add(arrConvertList(pre));
            return;
        }
        for (int i = begin + 1; i <= s.length(); i++) {
            String ifReserve = s.substring(begin, i);
            if (isPalindrome(ifReserve)) {
                findReverse(s, i, pre + ifReserve + ",", res);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return res;
        }
        findReverse(s, 0, "", res);
        return res;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution2 = new Q0128_longest_consecutive_sequence4();
        String s = "aab";
        List<List<String>> partition = solution2.partition(s);
        System.out.println(partition);
    }
}
