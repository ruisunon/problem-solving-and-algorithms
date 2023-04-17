package net.leetcode.questions.heap;

import java.util.PriorityQueue;

public class Q0703_kth_largest_element_in_a_stream {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public Q0703_kth_largest_element_in_a_stream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            add(nums[i]);
        }
    }

    // 注意特殊测试用例：nums 为空的情况，此时 minHeap.peek() 可能得到的值为空

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
            return minHeap.peek();
        } else {
            Integer top = minHeap.peek();
            if (val <= top) {
                return top;
            } else {
                minHeap.poll();
                minHeap.offer(val);
                return minHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[] nums = new int[]{};
        Q0703_kth_largest_element_in_a_stream obj = new Q0703_kth_largest_element_in_a_stream(k, nums);
        obj.add(-3);
    }
}
