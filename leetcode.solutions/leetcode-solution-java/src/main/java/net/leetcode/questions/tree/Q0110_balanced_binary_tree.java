package net.leetcode.questions.tree;

class Q0110_balanced_binary_tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Integer.max(left, right) + 1;
    }
}