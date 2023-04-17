package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0328_odd_even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNodeOdd = new ListNode(-1);
        ListNode dummyNodeEven = new ListNode(-1);
        ListNode curOdd = dummyNodeOdd;
        ListNode curEven = dummyNodeEven;
        int count = 0;
        while (head != null) {
            if ((count % 2) == 0) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            count++;
        }
        curOdd.next = dummyNodeEven.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curEven.next = null;
        return dummyNodeOdd.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        Q0328_odd_even_linked_list solution = new Q0328_odd_even_linked_list();
        ListNode oddEvenList = solution.oddEvenList(head);
        System.out.println(oddEvenList);
    }
}
