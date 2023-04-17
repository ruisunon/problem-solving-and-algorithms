package net.leetcode.questions.backtracking;

public class Q0112_path_sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 是叶子节点，这就是递归到底的情况了
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }
}
