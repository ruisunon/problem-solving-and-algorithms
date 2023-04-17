package net.leetcode.questions.stack;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1111_maximum_nesting_depth_of_two_valid_parentheses_strings {

    // 贪心算法

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];

        char[] charArray = seq.toCharArray();
        for (int i = 1; i < len; i++) {
            if (charArray[i] == charArray[i - 1]) {
                res[i] = 1 - res[i - 1];
            } else {
                res[i] = res[i - 1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String seq = "(()())";
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] res = solution.maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(res));
    }
}
