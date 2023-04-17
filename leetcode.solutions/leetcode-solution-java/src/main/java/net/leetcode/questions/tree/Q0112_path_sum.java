package net.leetcode.questions.tree;

/**
 * @author liweiwei1419
 * @date 2019/10/15 11:54 上午
 */
public class Q0112_path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}
