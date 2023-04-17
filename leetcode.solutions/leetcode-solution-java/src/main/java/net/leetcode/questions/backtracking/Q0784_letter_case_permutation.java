package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0784_letter_case_permutation {

    public List<String> letterCasePermutation(String S) {
        int len = S.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        char[] charArray = new char[len];
        dfs(S, 0, len, charArray, res);
        return res;
    }

    private void dfs(String S, int start, int len, char[] charArray, List<String> res) {
        if (start == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[start] = S.charAt(start);
        dfs(S, start + 1, len, charArray, res);

        // 如果是字符，就可以派生出一个新分支
        if (Character.isLetter(S.charAt(start))) {
            charArray[start] = (char) (S.charAt(start) ^ (1 << 5));
            dfs(S, start + 1, len, charArray, res);
        }
    }

    public static void main(String[] args) {
        // 97
        System.out.println((int) 'a');
        // 65
        System.out.println((int) 'A');

        Q0027_remove_element solution = new Q0027_remove_element();
        String S = "";
        List<String> letterCasePermutation = solution.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }
}
