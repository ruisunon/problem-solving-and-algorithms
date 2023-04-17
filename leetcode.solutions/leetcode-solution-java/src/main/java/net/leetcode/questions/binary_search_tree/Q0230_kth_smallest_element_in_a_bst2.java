package net.leetcode.questions.binary_search_tree;

public class Q0230_kth_smallest_element_in_a_bst2 {

    private int res;

    // 使用中序遍历

    public int kthSmallest(TreeNode root, int k) {
        int[] kArr = {k};
        inOrder(root, kArr);
        return res;
    }

    private void inOrder(TreeNode node, int[] k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        k[0]--;
        if (k[0] == 0) {
            res = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
