package net.leetcode.questions.stack;

import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0331_verify_preorder_serialization_of_a_binary_tree {

    // 9,3,4,#,#,1,#,#,2,#,6,#,#

    // 9,3,4,#,#
    // 9,3,#
    // 9,3,#,1,#,#
    // 9,3,#,#

    // 9,#

    // 9,#,2,#,6,#,#

    // 9,#,#

    // #

    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");
        int len = splits.length;

        // 特判
        if (len == 1 && "#".equals(splits[0])) {
            return true;
        }
        if (len < 3) {
            return false;
        }
        if (!"#".equals(splits[len - 1]) && !"#".equals(splits[len - 2])) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        stack.push(splits[0]);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && "#".equals(stack.peek())) {
                stack.pop();

                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(splits[i]);
        }
        return !stack.isEmpty() && "#".equals(stack.peek());
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        // String preorder = "1,#,#,#,#";
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean res = solution.isValidSerialization(preorder);
        System.out.println(res);
    }
}
