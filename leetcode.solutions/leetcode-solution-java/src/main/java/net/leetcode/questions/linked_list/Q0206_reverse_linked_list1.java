package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0206_reverse_linked_list1 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head2 = new ListNode(nums);
        System.out.println(head2);
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        ListNode reverseList = solution2.reverseList(head2);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}
