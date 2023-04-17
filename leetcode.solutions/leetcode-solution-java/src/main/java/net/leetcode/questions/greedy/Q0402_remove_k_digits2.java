package net.leetcode.questions.greedy;

import java.util.Stack;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0402_remove_k_digits2 {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char curNum = num.charAt(i);
            while (stack.size() > 0 && k > 0 && stack.peek() > curNum) {
                stack.pop();
                k--;
            }
            if (curNum != '0' || stack.size() > 0) {
                stack.add(curNum);
            }
        }
        while (stack.size() != 0 && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        String removeKdigits = solution3.removeKdigits(num, k);
        System.out.println(removeKdigits);
    }
}
