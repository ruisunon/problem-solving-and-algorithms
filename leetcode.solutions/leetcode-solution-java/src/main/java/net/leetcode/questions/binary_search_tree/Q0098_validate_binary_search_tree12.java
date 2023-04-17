package net.leetcode.questions.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0098_validate_binary_search_tree12 {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = - Integer.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
