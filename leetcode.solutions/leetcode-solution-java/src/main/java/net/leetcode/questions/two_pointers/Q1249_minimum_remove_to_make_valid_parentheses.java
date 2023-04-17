package net.leetcode.questions.two_pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

/**
 * @author liweiwei1419
 * @date 2019/11/3 7:34 下午
 */
public class Q1249_minimum_remove_to_make_valid_parentheses {

    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        // 存的是索引
        Stack<Integer> stack = new Stack<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    right.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(stack);
        System.out.println(right);
        right.addAll(stack);

        Collections.sort(right);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {

        }

        return "";
    }


    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String s = "a)b(c)d";
        String res = solution.minRemoveToMakeValid(s);
        System.out.println(res);
    }

}
