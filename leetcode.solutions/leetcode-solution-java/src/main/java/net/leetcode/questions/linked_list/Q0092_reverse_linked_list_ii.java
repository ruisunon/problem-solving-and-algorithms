package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0092_reverse_linked_list_ii {

    // 复杂的「穿针引线」，使用 3 个指针

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println("反转之后");
        ListNode reverseBetween = new Q0027_remove_element().reverseBetween(head, 2, 4);
        System.out.println(reverseBetween);
    }
}
