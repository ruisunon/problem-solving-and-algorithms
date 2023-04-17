package net.leetcode.questions.tree;

public class Q0114_flatten_binary_tree_to_linked_list {

    private TreeNode parent;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = parent;
        root.left = null;

        // 暂存父亲节点
        parent = root;
    }
}
