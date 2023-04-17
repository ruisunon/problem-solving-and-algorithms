package net.leetcode.questions.bucket_sort;

import java.util.ArrayList;
import java.util.List;

public class Q0448_find_all_numbers_disappeared_in_an_array3 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        int[] postion = new int[len + 1];
        for (int num : nums) {
            if (postion[num] == 0) {
                postion[num] = num;
            }
        }
        for (int i = 1; i < len + 1; i++) {
            if (postion[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
