package net.leetcode.questions.stack;

import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0682_baseball_game {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                // 为了看到第 2 个数，第 1 个数得 pop 掉，然后再放回栈
                int score1 = stack.pop();
                int score2 = stack.peek();

                stack.push(score1);
                stack.push(score1 + score2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                int score = stack.peek();
                stack.push(score * 2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.calPoints(ops);
        System.out.println(res);
    }


}
