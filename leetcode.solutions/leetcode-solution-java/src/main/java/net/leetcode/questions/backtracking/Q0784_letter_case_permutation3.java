package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0784_letter_case_permutation3 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        // 特判
        int len = S.length();
        if (len == 0) {
            return res;
        }
        Stack<Character> path = new Stack<>();
        dfs(S, 0, len, path, res);
        return res;
    }

    private void dfs(String S, int index, int len, Stack<Character> stack, List<String> res) {
        if (index == len) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                stringBuilder.append(stack.get(i));
            }
            res.add(stringBuilder.toString());
            return;
        }

        stack.add(S.charAt(index));
        dfs(S, index + 1, len, stack, res);
        stack.pop();

        if (Character.isLetter(S.charAt(index))) {
            stack.add((char) (S.charAt(index) ^ (1 << 5)));
            dfs(S, index + 1, len, stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        String S = "a1b2";
        List<String> letterCasePermutation = solution4.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }
}

