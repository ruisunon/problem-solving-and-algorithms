package net.leetcode.questions.linked_list;

import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1290_convert_binary_number_in_a_linked_list_to_integer1 {

    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        Stack<Integer> stack = new Stack<>();
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }

        int res = 0;
        int base = 1;
        while (!stack.isEmpty()) {
            res += base * stack.pop();
            base *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        int[] arr = {1, 0, 1};
        ListNode head = new ListNode(arr);
        Q1290_convert_binary_number_in_a_linked_list_to_integer1 solution = new Q1290_convert_binary_number_in_a_linked_list_to_integer1();
        int res = solution.getDecimalValue(head);
        System.out.println(res);
    }
}
