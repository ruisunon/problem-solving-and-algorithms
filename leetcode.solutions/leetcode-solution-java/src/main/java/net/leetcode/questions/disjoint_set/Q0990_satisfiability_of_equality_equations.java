package net.leetcode.questions.disjoint_set;

public class Q0990_satisfiability_of_equality_equations {

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '=') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';
                unionFind.union(index1, index2);
            }
        }

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '!') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';
                if (unionFind.isConnected(index1, index2)) {
                    // 如果合并失败，表示等式有矛盾，根据题意，返回 false
                    return false;
                }
            }
        }
        // 如果检查了所有不等式，都没有发现矛盾，返回 true
        return true;
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
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

        /**
         * @param x
         * @param y
         * @return 如果合并成功，返回 true
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


    public static void main(String[] args) {
        // String[] equations = new String[]{"b==a", "a==b"};
        // String[] equations = new String[]{"a==b","b==c","a==c"};
        // String[] equations = new String[]{"a==b","b!=c","c==a"};
        String[] equations = new String[]{"c==c", "b==d", "x!=z"};

        Q0990_satisfiability_of_equality_equations solution = new Q0990_satisfiability_of_equality_equations();
        boolean res = solution.equationsPossible(equations);
        System.out.println(res);
    }
}
