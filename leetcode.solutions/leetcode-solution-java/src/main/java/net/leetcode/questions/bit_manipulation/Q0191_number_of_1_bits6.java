package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits6 {

    public int hammingWeight(int n) {
        int res = 0;

        if (n < 0) {
            res++;
            n = -1 * n;
        }

        while (n != 0) {
            if (n % 2 == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q0191_number_of_1_bits6 solution7 = new Q0191_number_of_1_bits6();
        for (int i = -100; i < 100; i++) {
            int hammingWeight = solution7.hammingWeight(i);
            System.out.printf("%d ", hammingWeight);
            System.out.println(Integer.bitCount(i));
        }
        System.out.println("11111111111111111111111111111111".length());

        // 极端测试用例
        // 4294967295 (11111111111111111111111111111111)
        System.out.println((long) 1 << 32);
    }
}
