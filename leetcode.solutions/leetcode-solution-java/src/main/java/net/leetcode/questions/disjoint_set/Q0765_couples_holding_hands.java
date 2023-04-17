package net.leetcode.questions.disjoint_set;

public class Q0765_couples_holding_hands {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            unionFind.union(row[2 * i] / 2, row[2 * i + 1] / 2);
        }
        return N - unionFind.count;
    }

    private class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }

    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        // int[] row = {3, 2, 0, 1};
        Q0765_couples_holding_hands solution = new Q0765_couples_holding_hands();

        int res = solution.minSwapsCouples(row);
        System.out.println(res);
    }
}
