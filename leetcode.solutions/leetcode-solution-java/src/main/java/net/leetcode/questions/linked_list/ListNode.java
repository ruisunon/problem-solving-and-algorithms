package net.leetcode.questions.linked_list;

public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public ListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("数组不能为空");
    }
    this.val = arr[0];
    ListNode curr = this;
    for (int i = 1; i < arr.length; i++) {
      curr.next = new ListNode(arr[i]);
      curr = curr.next;
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    ListNode cur = this;
    while (cur != null) {
      s.append(cur.val);
      s.append(" -> ");
      cur = cur.next;
    }
    s.append("NULL");
    return s.toString();
  }
}