package net.leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0229_majority_element_ii {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        int num1 = 0;
        int num2 = 0;

        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num1 == num) {
                c1++;
            } else if (num2 == num) {
                c2++;
            } else if (c1 == 0) {
                num1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        // 初始化这两个计数器的值
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == num1) {
                c1++;
            }
            if (num == num2) {
                c2++;
            }
        }
        if (c1 > len / 3) {
            res.add(num1);
        }
        // 这里要注意 num1 != num2 这种特殊情况
        if (c2 > len / 3 && num1 != num2) {
            res.add(num2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 2, 1, 1, 3};
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.majorityElement(nums);
        System.out.println(res);
    }
}
