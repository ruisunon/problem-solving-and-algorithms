package net.leetcode.questions.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * @author liwei
 * @date 2019/8/10 3:46 PM
 */
public class Q0215_kth_largest_element_in_an_array8 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len) {
            throw new IllegalArgumentException("参数错误");
        }
        // 使用一个含有 len 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(a -> a));
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int solution2KthLargest = solution3.findKthLargest(nums, k);
        System.out.println(solution2KthLargest);
    }
}
