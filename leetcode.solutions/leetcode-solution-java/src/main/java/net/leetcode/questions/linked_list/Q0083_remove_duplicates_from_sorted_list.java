package net.leetcode.questions.linked_list;

public class Q0083_remove_duplicates_from_sorted_list {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}