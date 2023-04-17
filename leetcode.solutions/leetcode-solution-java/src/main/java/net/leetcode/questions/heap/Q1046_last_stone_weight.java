package net.leetcode.questions.heap;

import java.util.PriorityQueue;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1046_last_stone_weight {

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();

            maxHeap.offer(head1 - head2);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        // int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones = {1, 3};
        int res = solution.lastStoneWeight(stones);
        System.out.println(res);
    }
}
