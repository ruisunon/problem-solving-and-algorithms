package net.leetcode.questions.linked_list;

public class Q0160_intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 特判
        if (headA == null || headB == null) {
            return null;
        }

        int aLen = getLenOfListNode(headA);
        int bLen = getLenOfListNode(headB);

        // 总是让 A 链表是短链表
        if (aLen > bLen) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        // 注意：这里要取绝对值
        int distance = Math.abs(aLen - bLen);
        for (int i = 0; i < distance; i++) {
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLenOfListNode(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}