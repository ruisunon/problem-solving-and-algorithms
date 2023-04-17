package net.leetcode.questions.binary_search;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0658_find_k_closest_elements2 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3;
        int x = 5;
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.findClosestElements(arr, k, x);
        System.out.println(res);
    }
}
