package net.leetcode.questions.binary_search_tree;

/**
 * 和 Q0169_majority_element 是一样的，可能更好理解一些吧
 */
public class Q0669_trim_a_binary_search_tree1 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        // 这一步如果不理解的话，可以画图帮助理解
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        assert root.val >= L && root.val <= R;
        // 此时 root 一定会被保留
        root.left = trimBST(root.left, L, root.val);
        root.right = trimBST(root.right, root.val, R);
        return root;
    }
}