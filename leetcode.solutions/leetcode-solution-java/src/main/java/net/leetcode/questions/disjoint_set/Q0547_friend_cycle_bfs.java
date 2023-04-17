package net.leetcode.questions.disjoint_set;

import java.util.LinkedList;
import java.util.Queue;
//Approach #2. BFS (Level traverse)
//
//    Start from one node, visit all its directly connected nodes, or visit all nodes in the same level.
//    Use visited array to mark already visited nodes.
//    Increment count when start with a new node.

public class Q0547_friend_cycle_bfs {
  public int findCircleNumBFS(int[][] M) {
    if (M == null || M.length == 0) return 0;
    int numCircle = 0;
    int n = M.length;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      // already visited, skip
      if (visited[i]) continue;
      queue.add(i);
      while (!queue.isEmpty()) {
        int curr = queue.poll();
        visited[curr] = true;
        for (int j = 0; j < n; j++) {
          if (M[curr][j] == 1 && !visited[j]) {
            queue.add(j);
          }
        }
      }
      numCircle++;
    }
    return numCircle;
  }
}