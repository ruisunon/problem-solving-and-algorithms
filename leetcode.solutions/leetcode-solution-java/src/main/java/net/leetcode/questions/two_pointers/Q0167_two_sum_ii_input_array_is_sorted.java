package net.leetcode.questions.two_pointers;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0167_two_sum_ii_input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 10, 2147483647};
        int target = 8;
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }
}
