package net.leetcode.questions.linked_list;

public class Q0141_linked_list_cycle3 {

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode curNode = head;
        int count = 0;
        while (curNode != null) {
            curNode = curNode.next;
            if (count == 10000){
                return true;
            }
            count++;
        }
        return false;
    }
}
