package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0204_count_primes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                // System.out.printf("质数 %d \t", i);
                count++;
            }
        }
        return count;
    }

    /**
     * 根据质数的定义判别一个数是否是质数
     *
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                // 这样写可以吗
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int countPrimes = solution.countPrimes(20);
        System.out.println(countPrimes);
    }
}
