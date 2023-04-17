package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q1290_convert_binary_number_in_a_linked_list_to_integer {

    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int res = 0;

        while (curNode != null) {
            res = res * 2 + curNode.val;
            curNode = curNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        int[] arr = {1, 0, 1};
        ListNode head = new ListNode(arr);
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int res = solution2.getDecimalValue(head);
        System.out.println(res);
    }
}
