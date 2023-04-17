package net.leetcode.questions.binary_search;

import java.util.ArrayList;
import java.util.List;


public class Q1237_find_positive_integer_solution_for_a_given_equation12 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1000;

        while (left <= 1000 && right >= 1) {
            int num = customfunction.f(left, right);
            if (num == z) {
                List<Integer> cur = new ArrayList<>();
                cur.add(left);
                cur.add(right);
                res.add(cur);

                left++;
                right--;

            } else if (num > z) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
