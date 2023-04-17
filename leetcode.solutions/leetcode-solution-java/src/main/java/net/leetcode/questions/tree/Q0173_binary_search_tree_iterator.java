package net.leetcode.questions.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0173_binary_search_tree_iterator {

    // 参考「力扣」第 94 题

    private Deque<TreeNode> stack;

    public Q0173_binary_search_tree_iterator(TreeNode root) {
        stack = new ArrayDeque<>();

        TreeNode curNode = root;
        while (curNode != null) {
            stack.addLast(curNode);
            curNode = curNode.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode top = stack.removeLast();
        if (top.right != null) {
            TreeNode p = top.right;
            while (p != null) {
                stack.addLast(p);
                p = p.left;
            }
        }
        return top.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */