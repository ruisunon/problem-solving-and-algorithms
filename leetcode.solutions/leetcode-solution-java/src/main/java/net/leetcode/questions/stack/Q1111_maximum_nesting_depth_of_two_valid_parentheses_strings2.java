package net.leetcode.questions.stack;

import java.util.Arrays;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q1111_maximum_nesting_depth_of_two_valid_parentheses_strings2 {

    // 栈

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        char[] charArray = seq.toCharArray();
        int[] res = new int[len];

        int left = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                left++;
                res[i] = left % 2;
            } else {
                res[i] = left % 2;
                left--;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        // String seq = "(()())";
        String seq = "()(())()";
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int[] res = solution3.maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(res));
    }
}
