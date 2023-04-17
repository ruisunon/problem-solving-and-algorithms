package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q1323_maximum_69_number {
    public int maximum69Number(int num) {
        int res = num;
        StringBuilder numStr = new StringBuilder(num + "");
        // System.out.println(numStr);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '6') {
                StringBuilder replace = new StringBuilder(numStr).replace(i, i + 1, "9");
                // System.out.println("-" + numStr + "-" + replace);
                res = Math.max(res, Integer.parseInt(replace.toString()));
                // continue;
            }

            if (numStr.charAt(i) == '9') {
                StringBuilder replace = new StringBuilder(numStr).replace(i, i + 1, "6");
                // System.out.println("-" + numStr + "-" + replace);
                res = Math.max(res, Integer.parseInt(replace.toString()));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 9999;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.maximum69Number(num);
        System.out.println(res);
    }
}
