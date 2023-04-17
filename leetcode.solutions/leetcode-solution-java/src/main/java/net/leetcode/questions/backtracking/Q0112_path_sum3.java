package net.leetcode.questions.backtracking;

/**
 * @author liweiwei1419
 * @date 2019/10/12 6:42 下午
 */


public class Q0112_path_sum3 {

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
   private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
