package net.leetcode.questions.disjoint_set;
//Approach #1. DFS
//
//    Do DFS starting from every node, use visited array to mark visited node.
//    For each node DFS, visit all its directly connected nodes.
//    For each node DFS, DFS search will search all connected nodes, thus we count one DFS as one connected component.

public class Q0547_friend_cycle_dfs {
  public int findCircleNumDFS(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) return 0;
    int n = M.length;
    int numCircles = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(M, i, visited, n);
        numCircles++;
      }
    }
    return numCircles;
  }

  private void dfs(int[][] M, int i, boolean[] visited, int n) {
    for (int j = 0; j < n; j++) {
      if (M[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(M, j, visited, n);
      }
    }
  }
}
