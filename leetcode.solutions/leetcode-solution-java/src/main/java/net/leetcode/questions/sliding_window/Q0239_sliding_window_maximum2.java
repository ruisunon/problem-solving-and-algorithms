package net.leetcode.questions.sliding_window;

import java.util.Arrays;
import java.util.LinkedList;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * @author liweiwei1419
 * @date 2019/10/12 3:47 下午
 */
public class Q0239_sliding_window_maximum2 {

    /**
     * 单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i >= k && queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            // 如果最大值在队首，必须移除
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int[] res = solution3.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
