package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q0107_binary_tree_level_order_traversal_ii1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<List<Integer>> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                curLevel.add(node.val);
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                }
            }
            stack.add(curLevel);
        }

        while (!stack.empty()){
            res.add(stack.pop());
        }
        return res;
    }
}
