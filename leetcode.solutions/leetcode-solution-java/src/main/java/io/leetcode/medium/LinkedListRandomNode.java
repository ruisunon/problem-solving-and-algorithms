package io.leetcode.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  /** @param head The linked list's head.
      Note that the head is guaranteed to be not null, so it contains at least one node. */
  ListNode head;
  Random rand;
  public Solution(ListNode head) {
    this.head = head;
    rand = new Random();
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode curr = head;
    int val = curr.val;
    for (int i = 1; curr.next != null; i++) {
      curr = curr.next;
      if (rand.nextInt(i + 1) == i) {
        val = curr.val;
      }
    }
    return val;
  }
}

/**
 * Your Q0169_majority_element object will be instantiated and called as such:
 * Q0169_majority_element obj = new Q0169_majority_element(head);
 * int param_1 = obj.getRandom();
 */
