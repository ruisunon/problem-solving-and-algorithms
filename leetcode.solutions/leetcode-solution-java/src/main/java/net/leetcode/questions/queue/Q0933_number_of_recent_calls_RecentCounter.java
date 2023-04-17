package net.leetcode.questions.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q0933_number_of_recent_calls_RecentCounter {

    private Queue<Integer> queue;

    public Q0933_number_of_recent_calls_RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
