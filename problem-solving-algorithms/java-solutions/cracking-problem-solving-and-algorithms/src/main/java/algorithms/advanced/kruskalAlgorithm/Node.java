package algorithms.advanced.kruskalAlgorithm;

public class Node {

    private int rank; // the approximate count of nodes below this node
	private int id; // a unique index for each node in the tree
	private Node parent;

	public Node(int rank, int id, Node parent) {
		this.rank = rank;
		this.id = id;
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
