package net.leetcode.questions.binary_search;

import java.util.ArrayList;
import java.util.List;

public class Q1237_find_positive_integer_solution_for_a_given_equation2 {

    // 注意：起点都是 1，终点是 1000

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }

        }
        return res;
    }
}
