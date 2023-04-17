package net.leetcode.questions.tree;

public class Q0100_is_same_tree4 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val
                && helper(node1.left, node2.right)
                && helper(node1.right, node2.left);
    }

    // 这是个练习，写了测试用例

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2L = new TreeNode(2);
        TreeNode node2R = new TreeNode(2);
        TreeNode node3L = new TreeNode(3);
        TreeNode node3R = new TreeNode(3);

        node1.left = node2L;
        node1.right = node2R;

        node2L.right = node3L;
        node2R.right = node3R;

        Q0399_evaluate_division5 solution5 = new Q0399_evaluate_division5();
        boolean symmetric = solution5.isSymmetric(node1);
        System.out.println(symmetric);
    }
}
