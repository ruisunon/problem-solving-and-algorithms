package net.leetcode.questions.linked_list;

import java.util.Stack;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0234_palindrome_linkedlist1 {
    // 分清楚奇数和偶数结点两种情况，不反转链表，借助栈完成回文链表的判断
    //      slow
    // 1，2，3，4，5

    //   slow
    // 1，2，3，4

    /**
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode fastNode = head;
        ListNode slowNode = head;
        stack.add(slowNode.val);

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            stack.add(slowNode.val);
        }
        if (fastNode.next == null) {
            // 链表有奇数个结点
            stack.pop();
        }
        slowNode = slowNode.next;
        while (slowNode != null) {
            if (stack.pop() != slowNode.val) {
                return false;
            }
            slowNode = slowNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int[] nums = {1, 2,  2, 1};
        ListNode head = new ListNode(nums);
        boolean palindrome = solution2.isPalindrome(head);
        System.out.println(palindrome);
    }
}
