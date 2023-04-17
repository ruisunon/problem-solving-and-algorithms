package net.leetcode.questions.hash_table;

import java.util.HashSet;
import java.util.Set;

class Q0202_happy_number1 {

    public boolean isHappy(int n) {
        Set<Integer> set1 = new HashSet<>();
        String numberStr = String.valueOf(n);
        while (true) {
            int sum = 0;
            for (int i = 0; i < numberStr.length(); i++) {
                sum += Math.pow(Integer.valueOf(String.valueOf(numberStr.charAt(i))), 2);
            }
            if (sum == 1) {
                return true;
            } else if (set1.contains(sum)) {
                return false;
            } else {
                set1.add(sum);
                numberStr = String.valueOf(sum);
            }
        }
    }
}
