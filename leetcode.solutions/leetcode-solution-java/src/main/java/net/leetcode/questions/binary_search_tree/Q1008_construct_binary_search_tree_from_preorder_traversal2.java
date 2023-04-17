package net.leetcode.questions.binary_search_tree;

public class Q1008_construct_binary_search_tree_from_preorder_traversal2 {

    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) {
            return null;
        }

        // 后序遍历
        TreeNode root = new TreeNode(A[i]);
        i++;
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
