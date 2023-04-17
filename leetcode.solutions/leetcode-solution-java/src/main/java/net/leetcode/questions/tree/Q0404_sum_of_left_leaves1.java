package net.leetcode.questions.tree;

/**
 * @author liwei
 * @date 18/7/3 下午9:44
 */
public class Q0404_sum_of_left_leaves1 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 判断是叶子结点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
