package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;

public class Q0109_sortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            nums.add(curNode.val);
            curNode = curNode.next;
        }
        int len = nums.size();
        return helper(nums,0,len-1);
    }

    private TreeNode helper(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}