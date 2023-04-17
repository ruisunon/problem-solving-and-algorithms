package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0025_reverse_nodes_in_k_group {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 使用递归写法的话，先考虑特殊情况
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        // 探测长度的结点
        ListNode tempNode = head;
        int curk = k;
        while (tempNode != null && curk != 0) {
            curk--;
            tempNode = tempNode.next;
        }
        // 如果够数了，先考虑反转
        if (curk == 0) {
            // 下面开始反转
            ListNode pre = null;
            ListNode curNode = head;
            for (int i = 0; i < k; i++) {
                ListNode nextNode = curNode.next;
                curNode.next = pre;
                pre = curNode;
                curNode = nextNode;
            }
            head.next = reverseKGroup(tempNode, k);
            return pre;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        ListNode head = new ListNode(nums);
        Q0027_remove_element solution = new Q0027_remove_element();
        ListNode reverseKGroup = solution.reverseKGroup(head, 2);
        System.out.println(reverseKGroup);
    }
}