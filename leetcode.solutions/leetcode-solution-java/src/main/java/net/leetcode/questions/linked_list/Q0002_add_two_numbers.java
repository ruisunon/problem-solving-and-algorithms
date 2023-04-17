package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;


public class Q0002_add_two_numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;

        // carry 是进位的意思，一开始不进位
        int carry = 0;

        // 注意：这里是或者
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(carry % 10);
            carry /= 10;
            curNode = curNode.next;
        }
        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5};
        int[] nums2 = new int[]{5};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);
        Q0027_remove_element solution = new Q0027_remove_element();
        ListNode addTwoNumbers = solution.addTwoNumbers(l1, l2);
        System.out.println(addTwoNumbers);
    }
}

