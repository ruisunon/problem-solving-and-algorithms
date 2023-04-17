package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0140_word_break_ii1 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：长度为 i 的子字符串是否符合题意
        boolean[] dp = new boolean[len + 1];

        // 预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        // 这个状态的设置非常关键，说明前部分的字符串已经在 wordSet 中
        dp[0] = true;
        for (int r = 1; r < len + 1; r++) {
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[l] && wordSet.contains(s.substring(l, r))  ) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, len, wordSet, res, queue, dp);
            return res;
        }

        return res;
    }

    private void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (end == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < end; i++) {
            if (dp[i]) {
                String suffix = s.substring(i, end);
                if (wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordSet, res, queue, dp);
                    queue.removeFirst();
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        List<String> res = solution2.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
