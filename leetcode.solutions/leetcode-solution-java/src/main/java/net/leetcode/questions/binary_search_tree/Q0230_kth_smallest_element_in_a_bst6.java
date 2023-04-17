package net.leetcode.questions.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0230_kth_smallest_element_in_a_bst6 {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.addLast(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.removeLast();
            k--;
            if (k == 0) {
                return currentNode.val;
            }
            currentNode = currentNode.right;
        }
        return -1;
    }
}
