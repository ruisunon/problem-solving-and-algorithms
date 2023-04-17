package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

// 难点在于递归方法的设计
// 这个问题是一个典型的树形问题，体现的递归（recursion）过程是：之前的字符串 + 当前考虑字符，就能得到一个新的字符串。

public class Q0017_letter_combinations_of_a_phone_number3 {

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) { // Combination 组合
        if (digits.length() == 0) {
            return result;
        }
        dfs(digits, 0, "");
        return result;
    }

    /**
     * 找到 index 索引代表的数字字符串，并且获得 digits[0,...,index] 翻译得到的字符串
     *
     * @param digits 原始的数字字符串
     * @param index  当前定位到了原始数字字符串的哪个位置
     * @param pre    pre 保存了从 digits[0,...,index-1] 翻译得到的其中一个字符串
     *               这里 pre.length == index 的结果为 true
     */
    private void dfs(String digits, int index, String pre) {
        // 0 对应空格，1 不对应任何字母，这里虽然写上了，但是只是占了一个位置
        String[] digitsMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 先处理递归到底的情况
        // 已经走到了最后一位 + 1，即当前如果定位到了最大索引的下一个，就是取不到值的情况，函数就可以返回了
        if (index == digits.length()) {
            // 体会这一步是很关键的
            result.add(pre);
            return;
        }
        // 当前数字所表示的字符串
        // assert c >= '0' || c <= '9' || c != '1';
        String currStr = digitsMap[digits.charAt(index) - '0'];
        for (int i = 0; i < currStr.length(); i++) {
            dfs(digits, index + 1, pre + currStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        List<String> result = solution4.letterCombinations("23");
        System.out.println(result);
    }
}
