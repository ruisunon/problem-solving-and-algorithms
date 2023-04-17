package net.leetcode.questions.bucket_sort;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0448_find_all_numbers_disappeared_in_an_array2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
