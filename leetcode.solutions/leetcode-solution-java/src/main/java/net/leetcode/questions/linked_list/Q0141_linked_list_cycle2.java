package net.leetcode.questions.linked_list;

public class Q0141_linked_list_cycle2 {

    // 并查集的思路

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode dummyNode = new ListNode(-1);

        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;

            if (curNode != dummyNode) {
                curNode.next = dummyNode;
            } else {
                return true;
            }

            curNode = nextNode;
        }
        return false;
    }
}
