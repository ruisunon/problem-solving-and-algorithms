package net.leetcode.questions.tree;

public class Q0226_invert_binary_tree {

    /**
     * 使用前序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 左子树和右子树交换，即使左右子树都空也不影响正确性
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
