package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0693_binary_number_with_alternating_bits {

    public boolean hasAlternatingBits(int n) {
        // 题目说了是正数，所以负数可以直接排除了
        if (n <= 0) {
            return false;
        }
        boolean flag = ((n & 1) == 0);
        while ((n != 0)) {
            n >>= 1;
            boolean curFlag = ((n & 1) == 0);
            if (flag == curFlag) {
                return false;
            } else {
                flag = curFlag;
            }
        }
        // 这种检测，一定会将所有的数位都检查完，因此，
        // 能运行到最后的，一定都会返回 true
        return true;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        boolean hasAlternatingBits = solution.hasAlternatingBits(n);
        System.out.println(hasAlternatingBits);
    }
}
