package net.leetcode.questions.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0139_word_break {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        // 状态定义：前缀子串 s[0..i] 是否能够由 wordSet 中的单词拼写而成
        boolean[] dp = new boolean[len];
        for (int right = 0; right < len; right++) {
            if (wordSet.contains(s.substring(0, right + 1))) {
                dp[right] = true;
                continue;
            }
            for (int left = 0; left < right; left++) {
                if (dp[left] && wordSet.contains(s.substring(left + 1, right + 1))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Q0139_word_break solution = new Q0139_word_break();
        boolean res = solution.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
