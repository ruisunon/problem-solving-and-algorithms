package net.leetcode.questions.array;

import java.util.Arrays;

public class Q1299_replace_elements_with_greatest_element_on_right_side {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] minRight = new int[len];

        minRight[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            minRight[i] = Math.max(minRight[i + 1], arr[i + 1]);
        }

        minRight[len - 1] = -1;
        return minRight;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        Q1299_replace_elements_with_greatest_element_on_right_side solution = new Q1299_replace_elements_with_greatest_element_on_right_side();
        int[] res = solution.replaceElements(arr);
        System.out.println(Arrays.toString(res));
    }


}
