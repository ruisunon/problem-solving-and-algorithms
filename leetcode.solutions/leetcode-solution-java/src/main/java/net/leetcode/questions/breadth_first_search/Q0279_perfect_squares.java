package net.leetcode.questions.breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import net.leetcode.questions.array.Q0027_remove_element;


public class Q0279_perfect_squares {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        // 是否访问过
        boolean[] visited = new boolean[n + 1];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                for (int j = 1; j * j <= head; j++) {
                    if (j * j == head) {
                        return step;
                    }

                    int next = head - j * j;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step ++;
        }

        // 正常情况下是不会走到这句的
        throw new IllegalArgumentException("参数错误");
    }

    public static void main(String[] args) {
        int n = 7168;
        Q0027_remove_element s = new Q0027_remove_element();
        int numSquares = s.numSquares(n);
        System.out.println(numSquares);
    }
}