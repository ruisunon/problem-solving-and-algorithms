package net.leetcode.questions.heap;

import java.util.TreeSet;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q1296_divide_array_in_sets_of_k_consecutive_numbers2 {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }

        // TreeSet 不可以
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }

        while (!treeSet.isEmpty()) {
            Integer top = treeSet.first();
            treeSet.remove(top);

            for (int i = 1; i < k; i++) {
                // 从 1 开始，正好需要移除 k - 1 个元素
                // i 正好就是相对于 top 的偏移
                if (!treeSet.remove(top + i)) {
                    // 如果移除失败，说明划分不存在，直接返回 false 即可
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;
//        int[] nums = {3, 3, 2, 2, 1, 1};
//        int k = 3;

//        int[] nums = {1, 2, 3, 4};
//        int k = 3;

        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        boolean res = solution.isPossibleDivide(nums, k);
        System.out.println(res);
    }
}
