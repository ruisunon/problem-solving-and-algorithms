package net.leetcode.questions.tree;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0236_lowest_common_ancestor_of_a_binary_tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 这一句特别重要，如果左边和右边都非空，把当前结点返回回去
        if (left != null && right != null) {
            return root;
        }

        // 下面的这种写法包含了 left 和 right 同时为空的情况
        if (left == null) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;

        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;

        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        Q0236_lowest_common_ancestor_of_a_binary_tree solution = new Q0236_lowest_common_ancestor_of_a_binary_tree();
        TreeNode res = solution.lowestCommonAncestor(treeNode3, treeNode7, treeNode4);
        System.out.println(treeNode2.hashCode());
        System.out.println(res.hashCode());
    }
}
