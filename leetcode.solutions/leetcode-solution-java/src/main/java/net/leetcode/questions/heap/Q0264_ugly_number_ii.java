package net.leetcode.questions.heap;

import java.util.PriorityQueue;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0264_ugly_number_ii {

    // 使用优先队列

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);

        // 因为数字可能越乘越大，所以需要声明成 Long 类型
        Long res = minHeap.peek();

        for (int i = 0; i < n; i++) {
            res = minHeap.poll();

            // 因为有重复元素，要把重复元素去掉
            while (!minHeap.isEmpty() && res.equals(minHeap.peek())) {
                minHeap.poll();
            }

            minHeap.offer(res * 2);
            minHeap.offer(res * 3);
            minHeap.offer(res * 5);
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int n = 1407;
        long res = solution.nthUglyNumber(n);
        System.out.println(res);
    }
}
