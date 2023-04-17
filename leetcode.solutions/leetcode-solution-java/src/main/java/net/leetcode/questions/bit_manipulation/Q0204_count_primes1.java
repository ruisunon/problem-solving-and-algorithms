package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0204_count_primes1 {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                System.out.printf("质数 %d \t",i);
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int countPrimes = solution2.countPrimes(20);
        System.out.println(countPrimes);
    }
}
