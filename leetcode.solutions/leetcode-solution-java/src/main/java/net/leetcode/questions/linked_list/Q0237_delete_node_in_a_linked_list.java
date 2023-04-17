package net.leetcode.questions.linked_list;

import net.leetcode.questions.array.Q0027_remove_element;
public class Q0237_delete_node_in_a_linked_list {

    public void deleteNode(ListNode node) {
        // 第 1 步：把待删除结点的下一结点的值赋值给自己
        ListNode nextNode = node.next;
        node.val = nextNode.val;

        // 第 2 步：删除下一个结点
        node.next = nextNode.next;
        nextNode.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        Q0237_delete_node_in_a_linked_list solution = new Q0237_delete_node_in_a_linked_list();
        solution.deleteNode(node1);
    }
}