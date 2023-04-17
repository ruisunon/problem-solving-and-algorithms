package net.leetcode.questions.linked_list;

public class Q0024_swap_nodes_in_pairs3 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode newHead = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            newHead.next = second;
            first.next = second.next;
            second.next = first;

            newHead = first;
            head = first.next;
        }
        return dummy.next;
    }
}
