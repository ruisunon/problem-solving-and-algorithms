package net.leetcode.questions.linked_list;

import java.util.HashSet;
import java.util.Set;

public class Q0160_intersection_of_two_linked_lists2 {


    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();

        ListNode curNode = headA;
        while (curNode != null) {
            hashSet.add(curNode);
            curNode = curNode.next;
        }

        curNode = headB;
        while (curNode != null) {
            if(hashSet.contains(curNode)){
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}
