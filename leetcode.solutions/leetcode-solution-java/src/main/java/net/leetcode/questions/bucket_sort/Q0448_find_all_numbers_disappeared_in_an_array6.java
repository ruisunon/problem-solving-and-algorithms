package net.leetcode.questions.bucket_sort;

import java.util.ArrayList;
import java.util.List;

public class Q0448_find_all_numbers_disappeared_in_an_array6 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>(2);

        for (int i = 0; i < nums.length; i++) {
            // 数字 4 应该在下标 3 的位置上
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
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
        Q0547_friend_circles7 solution7 = new Q0547_friend_circles7();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = solution7.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
