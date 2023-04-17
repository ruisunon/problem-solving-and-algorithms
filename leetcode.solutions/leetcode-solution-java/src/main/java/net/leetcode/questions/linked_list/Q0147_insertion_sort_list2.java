package net.leetcode.questions.linked_list;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * @author liweiwei1419
 * @date 2019/11/29 2:48 下午
 */
public class Q0147_insertion_sort_list2 {

    // 代码的逻辑分析可以参考：https://liweiwei1419.github.io/images/leetcode-solution/147-2.jpg

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        // 用于遍历的指针
        ListNode curNode = head;
        ListNode next = null;
        // 没有这一步：dummyNode.next = head;
        while (curNode != null) {
            next = curNode.next;
            // 这一步是找到一个正确的位置插入，只要比 curNode 的值小，都应该跳过
            // 直到遇到第 1 个大于等于它的元素
            while (preNode.next != null && preNode.next.val < curNode.val) {
                preNode = preNode.next;
            }
            // 应该把 node 放在 pre 的下一个
            curNode.next = preNode.next;
            preNode.next = curNode;
            preNode = dummyNode;
            curNode = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 9, 10, 8};
        ListNode head = new ListNode(nums);
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        ListNode insertionSortList = solution3.insertionSortList(head);
        System.out.println(insertionSortList);
    }
}
