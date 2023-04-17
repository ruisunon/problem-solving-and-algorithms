package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0876_middle_of_the_linked_list {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Q0876_middle_of_the_linked_list solution = new Q0876_middle_of_the_linked_list();
        ListNode res = solution.middleNode(head);
        System.out.println(res);
    }
}
