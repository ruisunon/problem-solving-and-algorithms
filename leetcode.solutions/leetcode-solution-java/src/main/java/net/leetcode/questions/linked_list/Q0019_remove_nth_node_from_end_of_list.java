package net.leetcode.questions.linked_list;

// 快慢指针、虚拟结点
// 关键：使用待删除结点的上一个结点删除它
// 在草稿纸上画图，搞清边界条件
// 学会调试链表程序

public class Q0019_remove_nth_node_from_end_of_list {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLenOfNode(head);

        // 删除索引为 len - n 的结点
        // 有了虚拟头结点以后，就走 len - n 步，来到要删除的结点之前
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        for (int i = 0; i < len - n; i++) {
            curNode = curNode.next;
        }

        ListNode deleteNode = curNode.next;
        curNode.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }

    private int getLenOfNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}