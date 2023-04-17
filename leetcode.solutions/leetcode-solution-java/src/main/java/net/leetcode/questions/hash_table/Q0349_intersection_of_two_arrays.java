package net.leetcode.questions.hash_table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.leetcode.questions.array.Q0027_remove_element;


public class Q0349_intersection_of_two_arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int value : nums1) {
            set1.add(value);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int value : nums2) {
            if (set1.contains(value)) {
                set2.add(value);
            }
        }

        int size = set2.size();
        int[] res = new int[size];
        int next = 0;
        for (Integer num : set2) {
            res[next] = num;
            next++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = new Q0027_remove_element().intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
