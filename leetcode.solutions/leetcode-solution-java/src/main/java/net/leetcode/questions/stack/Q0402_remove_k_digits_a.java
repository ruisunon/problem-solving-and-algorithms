package net.leetcode.questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0402_remove_k_digits_a {

    // 单调栈

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        int remaining = len - k;
        char[] charArray = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        // System.out.println(stack);
        // 只取前面剩下的部分，针对 String num = "112"; int k = 1; 这种用例
        while (stack.size() > remaining) {
            stack.pollLast();
        }

        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.removeFirst();
        }

        if (stack.isEmpty()) {
            return "0";
        }
        return toString(stack);
    }

    private String toString(Deque<Character> stack){
        int size = stack.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.removeFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String num = "112";
        int k = 1;

        Q0027_remove_element solution = new Q0027_remove_element();
        String res = solution.removeKdigits(num, k);
        System.out.println(res);
    }
}
