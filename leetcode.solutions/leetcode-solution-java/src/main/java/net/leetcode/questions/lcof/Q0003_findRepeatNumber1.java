package net.leetcode.questions.lcof;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0003_findRepeatNumber1 {

    public int findRepeatNumber(int[] nums) {
        int hash = 0;
        for (int num : nums) {
            if (((hash >> num) & 1) == 1) {
                return num;
            }
            hash ^= (1 << num);
        }
        throw new IllegalArgumentException("数组中没有重复的数字");
    }


    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int res = solution3.findRepeatNumber(nums);
        System.out.println(res);
    }
}
