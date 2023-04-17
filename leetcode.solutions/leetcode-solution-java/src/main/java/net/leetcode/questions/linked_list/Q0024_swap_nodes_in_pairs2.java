package net.leetcode.questions.linked_list;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0024_swap_nodes_in_pairs2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        // 没有必要这么写
        p2.next = swapPairs(p2.next);
        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }
    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4};
        ListNode head = new ListNode(nums);
        Q0128_longest_consecutive_sequence3 solution2 = new Q0128_longest_consecutive_sequence3();
        ListNode swapPairs = solution2.swapPairs(head);
        System.out.println(swapPairs);
    }
}
