package net.leetcode.questions.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class Q0230_kth_smallest_element_in_a_bst3 {

    private enum Action {
        // GO 表示递归处理
        // ADDTORESULT 表示当前马上执行将结点的值添加到结果集中
        GO, ADDTORESULT
    }

    private class Command {
        private Action action;
        private TreeNode node;

        public Command(Action action, TreeNode node) {
            this.action = action;
            this.node = node;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<Command> stack = new ArrayDeque<>();
        stack.addLast(new Command(Action.GO, root));
        while (!stack.isEmpty()) {
            Command cur = stack.removeLast();
            TreeNode node = cur.node;
            if (cur.action == Action.ADDTORESULT) {
                k--;
                if (k == 0) {

                    System.out.println(stack.size());
                    return node.val;
                }
            } else {
                assert cur.action == Action.GO;
                if (node.right != null) {
                    stack.addLast(new Command(Action.GO, node.right));
                }
                stack.add(new Command(Action.ADDTORESULT, node));
                if (node.left != null) {
                    stack.addLast(new Command(Action.GO, node.left));
                }
            }
        }
        throw new RuntimeException("参数错误");
    }
}
