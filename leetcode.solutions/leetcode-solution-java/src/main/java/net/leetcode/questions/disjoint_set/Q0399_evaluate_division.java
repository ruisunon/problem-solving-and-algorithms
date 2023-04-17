package net.leetcode.questions.disjoint_set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number
// (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
//
//    Example:
//    Given a / b = 2.0, b / c = 3.0.
//    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//    return [6.0, 0.5, -1.0, 1.0, -1.0 ].
//
//    The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
//    where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
//
//    According to the example above:
//
//    equations = [ ["a", "b"], ["b", "c"] ],
//    values = [2.0, 3.0],
//    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
//The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

public class Q0399_evaluate_division {

    // 带权并查集问题，构建有向图

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 第 1 步：给每一个字符串生成一个 id ，方便在并查集中做操作
        int equationsSize = equations.size();
        Map<String, Integer> hashMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(2 * equationsSize);

        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {

                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }


    private class UnionFind {

        private int[] parent;

        /**
         * 把父结点作为分母时的商
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
            // 需要列方程计算
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                // 难点：这里维护 weight 的定义
                int origin = parent[x];
                parent[x] = find(parent[x]);

                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("a");
        item1.add("b");

        List<String> item2 = new ArrayList<>();
        item2.add("b");
        item2.add("c");

        equations.add(item1);
        equations.add(item2);

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");

        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");

        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");

        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");

        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        Q0399_evaluate_division solution = new Q0399_evaluate_division();
        double[] res = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }
}
