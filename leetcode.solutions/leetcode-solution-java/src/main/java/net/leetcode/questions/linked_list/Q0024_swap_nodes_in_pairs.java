package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0024_swap_nodes_in_pairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;

        while (curNode.next != null && curNode.next.next != null) {
            // 重新初始化 p1 和 p2
            ListNode p1 = curNode.next;
            ListNode p2 = p1.next;

            // 穿针引线的步骤就 3 步
            p1.next = p2.next;
            p2.next = p1;
            curNode.next = p2;

            // 循环变量更新
            curNode = p1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        Q0027_remove_element solution = new Q0027_remove_element();
        ListNode swapPairs = solution.swapPairs(head);
        System.out.println(swapPairs);
    }
}



