package net.interviews.revisit.algorithms;

// 1) Use two pointers fast and slow
// 2) Move fast two nodes and slow one node in each iteration
// 3) If fast and slow meet then linked list contains cycle
// 4) if fast points to null or fast.next points to null then linked list is not cyclic

public class CyclicLinkedList {

	private Node head;

	public CyclicLinkedList() {
		this.head = new Node("head");
	}

	public Node head() {
		return head;
	}

	public void appendIntoTail(Node node) {
		Node current = head;
		// find last element of LinkedList i.e. tail
		while (current.next() != null) {
			current = current.next();
		}
		// appending new node to tail in LinkedList
		current.setNext(node);
	}

	/*
	 * * If singly LinkedList contains Cycle then following would be true 1) slow
	 * and fast will point to same node i.e. they meet On the other hand if fast
	 * will point to null or next node of fast will point to null then LinkedList
	 * does not contains cycle.
	 */
	public boolean isCyclic() {
		Node fast = head;
		Node slow = head;
		int loop=0;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// if fast and slow pointers are meeting then LinkedList is cyclic
			if (fast == slow) {
				System.out.println("LinkedList running about loop=:" + loop);
				return true;
			}
			loop++;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head.next();
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next();
		}
		sb.delete(sb.length() - 3, sb.length());
		// to remove --> from last node
		return sb.toString();
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return this.data;
		}
	}
}