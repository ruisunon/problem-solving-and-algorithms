package net.leetcode.questions.queue;

public class Q1315_sum_of_nodes_with_even_valued_grandparent1 {

    private int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null);
        return res;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (parent != null && parent.val % 2 == 0) {
            if (root.left != null) {
                res += root.left.val;
            }
            if (root.right != null) {
                res += root.right.val;
            }
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }

}
