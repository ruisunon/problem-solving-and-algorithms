package net.leetcode.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1313_decompress_run_length_encoded_list {

    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);

        for (int i = 0; i < len / 2; i++) {
            int count = nums[2 * i];
            int val = nums[2 * i + 1];

            for (int j = 0; j < count; j++) {
                res.add(val);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] res = solution.decompressRLElist(nums);
        System.out.println(Arrays.toString(res));
    }
}
