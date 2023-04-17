package net.leetcode.questions.disjoint_set;

public class Q0952_largest_component_size_by_common_factor {

    /**
     * 找到这个数所有的质数因子，然后把它们合并在一起
     *
     * @param A
     * @return
     */
    public int largestComponentSize(int[] A) {
        int maxVal = 1;
        for (int item : A) {
            maxVal = Math.max(maxVal, item);
        }

        UnionFind unionFind = new UnionFind(maxVal + 1);
        for (int num : A) {
            double upBound = Math.sqrt(num);
            // 注意 i <= upBound; 等于这里不要漏掉
            for (int i = 2; i <= upBound; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }

            }
        }

        int res = 0;
        int[] cnt = new int[maxVal + 1];
        for (int value : A) {
            int root = unionFind.find(value);
            cnt[root]++;
            res = Math.max(res, cnt[root]);
        }
        return res;
    }


    /**
     * 用到了路径压缩，没有用到按 size 合并
     */
    private class UnionFind {

        private int[] parent;


        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         *
         * @param x
         * @return
         */
        public int find(int x) {

            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {

            parent[find(x)] = parent[find(y)];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 6, 15, 35};
        Q0952_largest_component_size_by_common_factor solution = new Q0952_largest_component_size_by_common_factor();
        int res = solution.largestComponentSize(A);
        System.out.println(res);
    }
}
