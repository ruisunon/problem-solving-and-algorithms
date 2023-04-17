package net.leetcode.questions.tree;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 */
public class Q0404_sum_of_left_leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 表明是叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
