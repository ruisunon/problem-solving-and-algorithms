package net.leetcode.questions.lcci;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q_08_06_hanota_lcci {

    public void hanota(int[] A, int[] B, int[] C) {
        int len = A.length;
        System.out.println(len);
        C = new int[len];
        System.out.println(Arrays.toString(C));

        System.arraycopy(A, 0, C, 0, len);
        System.out.println(Arrays.toString(C));


        Arrays.fill(A, 0);
    }

    public static void main(String[] args) {
        int[] A = {0};
        int[] B = {};
        int[] C = {};
        Q0027_remove_element solution = new Q0027_remove_element();
        solution.hanota(A,B,C);
        System.out.println(Arrays.toString(C));
    }
}
