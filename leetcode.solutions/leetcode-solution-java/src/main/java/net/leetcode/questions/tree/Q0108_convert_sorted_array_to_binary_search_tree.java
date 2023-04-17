package net.leetcode.questions.tree;

public class Q0108_convert_sorted_array_to_binary_search_tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return merge(nums, 0, len - 1);
    }

    private TreeNode merge(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = (left + right) >>> 1;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = merge(nums, left, mid - 1);
        treeNode.right = merge(nums, mid + 1, right);
        return treeNode;
    }
}
