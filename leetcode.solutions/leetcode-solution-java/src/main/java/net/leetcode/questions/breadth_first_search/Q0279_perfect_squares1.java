package net.leetcode.questions.breadth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Q0279_perfect_squares1 {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        Set<Integer> visited = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int j = 1; j * j <= num; j++) {
                    int next = num - j * j;
                    if (next == 0) {
                        return step;
                    }
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }
}
