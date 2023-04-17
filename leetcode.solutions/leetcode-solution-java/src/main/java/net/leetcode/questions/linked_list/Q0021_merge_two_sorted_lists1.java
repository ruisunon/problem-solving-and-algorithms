package net.leetcode.questions.linked_list;

public class Q0021_merge_two_sorted_lists1 {

    /**
     * 使用递归
     *
     * @param l1 有序链表
     * @param l2 有序链表
     * @return 有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 先写递归终止的条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 假设规模小的问题已经解决，如何建立和原始规模问题之间的关系
        if (l1.val < l2.val) {
            // l1 被选出，谁小谁在前面
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // l2 被选出，谁小谁在前面
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
