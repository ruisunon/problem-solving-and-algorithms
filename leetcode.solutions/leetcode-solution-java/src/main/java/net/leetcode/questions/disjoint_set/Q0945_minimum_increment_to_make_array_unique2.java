package net.leetcode.questions.disjoint_set;
import java.util.HashMap;
import java.util.Map;

public class Q0945_minimum_increment_to_make_array_unique2 {

    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(len);
        int res = 0;
        for (int num : A) {
            if (unionFind.contains(num)) {
                int root = unionFind.find(num);
                int add = root + 1;
                res += (add - num);
                unionFind.init(add);
            } else {
                unionFind.init(num);
            }
        }
        return res;
    }

    private class UnionFind {
        /**
         * union and find
         */
        private Map<Integer, Integer> parent;

        public void init(int x) {
            parent.put(x, x);
            if (parent.containsKey(x - 1) ) {
                union(x, x - 1);
            }
            if (parent.containsKey(x + 1) ) {
                union(x, x + 1);
            }
        }

        public boolean contains(int x) {
            return parent.containsKey(x);
        }

        public UnionFind(int n) {
            this.parent = new HashMap<>(n);
        }

        /**
         * return the root element
         *
         * @param x
         * @return 针对这道题，代表元选所有元素中最大的那个
         */
        public int find(int x) {
            while (x != parent.get(x)) {
                // 只要自己的父亲结点不是自己，就说明不是根结点，继续往上找 x = parent[x];
                // 这句是路径压缩，并查集的优化，不加也行
                // parent[x] = parent[parent[x]]; 把 x 的父结点指向父亲结点的父亲结点
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            // 注意：根据这个问题的特点
            // 只能把小的结点指向大的结点
            if (rootX < rootY) {
                parent.put(rootX, rootY);
            }

            if (rootY < rootX) {
                parent.put(rootY, rootX);
            }
        }
    }



    public static void main(String[] args) {
        Q0945_minimum_increment_to_make_array_unique2 solution2 = new Q0945_minimum_increment_to_make_array_unique2();
        // int[] A = new int[]{1, 2, 2};
        int[] A = new int[]{7, 2, 7, 2, 1, 4, 3, 1, 4, 8};
        int res = solution2.minIncrementForUnique(A);
        System.out.println(res);
    }
}
