package net.leetcode.questions.tree;

// 求一棵二叉树的最大深度

public class Q0104_maximum_depth_of_binary_tree {

    // 后序遍历

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}