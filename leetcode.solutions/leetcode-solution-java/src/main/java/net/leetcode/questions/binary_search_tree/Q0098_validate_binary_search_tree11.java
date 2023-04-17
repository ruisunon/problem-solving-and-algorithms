package net.leetcode.questions.binary_search_tree;

public class Q0098_validate_binary_search_tree11 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
