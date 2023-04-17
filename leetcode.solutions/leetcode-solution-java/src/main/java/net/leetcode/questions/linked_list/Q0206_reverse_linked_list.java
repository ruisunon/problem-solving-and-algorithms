package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0206_reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Q0206_reverse_linked_list solution = new Q0206_reverse_linked_list();
        ListNode reverseList = solution.reverseList(head);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}