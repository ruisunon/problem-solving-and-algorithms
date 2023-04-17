package net.leetcode.questions.linked_list;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0234_palindrome_linkedlist {

    // 放在一个动态数组中，然后判断这个动态数组的回文性

    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return judgeArrPalindrome(arr);
    }

    private boolean judgeArrPalindrome(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (arr.get(left).equals(arr.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 2, 1};
        Q0234_palindrome_linkedlist solution = new Q0234_palindrome_linkedlist();
        ListNode head = new ListNode(nums);
        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
    }
}
