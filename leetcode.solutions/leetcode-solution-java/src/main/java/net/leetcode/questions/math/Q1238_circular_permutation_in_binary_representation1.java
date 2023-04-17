package net.leetcode.questions.math;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;


/**
 * @author liweiwei1419
 * @date 2019/11/2 5:03 下午
 */
public class Q1238_circular_permutation_in_binary_representation1 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> grayCode = new ArrayList<>(1 << n);
        grayCode.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int size = grayCode.size();
            for (int j = size - 1; j >= 0; j--) {
                grayCode.add(head + grayCode.get(j));
            }
            head <<= 1;
        }

        int index = 0;
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            if (grayCode.get(i) == start) {
                index = i;
                break;
            }
        }

        List<Integer> res = new ArrayList<>(size);
        for (int i = index; i < size; i++) {
            res.add(grayCode.get(i));
        }
        for (int i = 0; i < index; i++) {
            res.add(grayCode.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int start = 3;
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        List<Integer> res = solution2.circularPermutation(n, start);
        System.out.println(res);
    }
}
