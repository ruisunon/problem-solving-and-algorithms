package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.Map;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0525_contiguous_array1 {

    // 从左到右扫描数组，维护连续的 0 和 1 数量的差值第一次出现的位置
    // 后面如果出现一样的差值，两个位置相减

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>(len);
        map.put(0, -1);

        int res = 0;
        // diff = count(one) - count(zero)
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                diff--;
            } else {
                diff++;
            }

            if (map.containsKey(diff)) {
                res = Math.max(res, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int[] nums = {0, 1};
        int res = solution.findMaxLength(nums);
        System.out.println(res);
    }
}
