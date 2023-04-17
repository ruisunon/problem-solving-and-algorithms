package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0203_remove_linked_list_elements {

    // 穿针引线

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 待删除的结点
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        Q0027_remove_element solution = new Q0027_remove_element();
        solution.removeElements(head, 6);
        System.out.println(head);
    }
}
