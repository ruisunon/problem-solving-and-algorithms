package net.leetcode.questions.stack;

import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0946_validate_stack_sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len1 = pushed.length;
        int len2 = popped.length;

        if (len1 == 0 && len2 == 0){
            return true;
        }

        if (len2 == 0 || len1 != len2) {
            return false;
        }

        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len1; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }

            // 调试代码
            // System.out.println(stack);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean res = solution.validateStackSequences(pushed, popped);
        System.out.println(res);
    }
}
