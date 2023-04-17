package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0082_remove_duplicates_from_sorted_list_ii {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 只要涉及头结点的操作，设置虚拟头结点避免对链表第 1 个结点的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            // 如果接连两个结点的 val 相等，至少要把它们都删掉
            if (curNode.next.val == curNode.next.next.val) {
                // 要删除的起点至少应该是当前判断相同的结点的第 2 个
                ListNode delNode = curNode.next.next;
                // 如果后面还有相同的结点，delNode 后移一位，即 delNode 应该是指向相同的结点的最后一个
                while (delNode.next != null && delNode.next.val == delNode.val) {
                    delNode = delNode.next;
                }
                curNode.next = delNode.next;
                delNode.next = null;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9};
        ListNode head = new ListNode(nums);
        Q0027_remove_element solution = new Q0027_remove_element();
        ListNode deleteDuplicates = solution.deleteDuplicates(head);
        System.out.println(deleteDuplicates);
    }
}


