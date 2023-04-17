package net.leetcode.questions.bucket_sort;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * @author liweiwei1419
 * @date 2019/10/11 12:13 下午
 */
public class Q0448_find_all_numbers_disappeared_in_an_array5 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            int index = (nums[i] - 1) % len;
            // System.out.println(i + " " +index + " " + (nums[i] - 1));
            nums[index] += len;
            // System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        List<Integer> res = solution2.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
