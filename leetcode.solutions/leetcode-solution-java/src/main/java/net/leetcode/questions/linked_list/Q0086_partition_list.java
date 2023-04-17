package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0086_partition_list {

    // 空间复杂度为 O(1) 的解法：穿针引线

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 比 x 小的虚拟头结点
        ListNode dummyNodeL = new ListNode(-1);
        // 大于等于 x 的虚拟头结点
        ListNode dummyNodeR = new ListNode(-1);
        // 用于遍历
        ListNode curL = dummyNodeL;
        // 用于遍历
        ListNode curR = dummyNodeR;
        int val;
        while (head != null) {
            val = head.val;
            if (val < x) {
                curL.next = head;
                curL = curL.next;
            } else {
                curR.next = head;
                curR = curR.next;
            }
            head = head.next;
        }
        curL.next = dummyNodeR.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curR.next = null;
        return dummyNodeL.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int x = 3;
        ListNode head = new ListNode(nums);
        Q0027_remove_element solution = new Q0027_remove_element();
        System.out.println("分隔链表之后：");
        ListNode partition = solution.partition(head, x);
        System.out.println(partition);
    }
}
