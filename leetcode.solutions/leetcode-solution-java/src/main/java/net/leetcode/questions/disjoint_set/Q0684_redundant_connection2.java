package net.leetcode.questions.disjoint_set;

class Q0684_redundant_connection2 {
  public int[] findRedundantConnection(int[][] edges) {
    UnionFind uf = new UnionFind(edges.length);
    for (int[] edge : edges) {
      if (!uf.union(edge[0] - 1, edge[1] - 1)) return edge;
    }
    throw new IllegalArgumentException();
  }

  class UnionFind {
    private int[] parent;
    private byte[] rank;

    public UnionFind(int n) {
      if (n < 0) throw new IllegalArgumentException();
      parent = new int[n];
      rank = new byte[n];
    }

    public int find(int x) {
      if (parent[x] == 0) return x;
      return parent[x] = find(parent[x]); // Path compression
    }

    public boolean union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) return false;

      // Merge root of smaller rank to larger rank
      if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
      else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
      else {
        parent[rootX] = rootY;
        rank[rootY]++;
      }
      return true;
    }
  }
}