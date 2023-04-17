package net.leetcode.questions.string;

import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1081_smallest_subsequence_of_distinct_characters {

    public String smallestSubsequence(String text) {
        int len = text.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.empty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String text = "cdadabcc";
        String res = solution.smallestSubsequence(text);
        System.out.println(res);
    }
}
