package net.leetcode.questions.two_pointers;

public class Q0026_remove_duplicates_from_sorted_array1 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // j 是刚刚赋值完的索引
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
