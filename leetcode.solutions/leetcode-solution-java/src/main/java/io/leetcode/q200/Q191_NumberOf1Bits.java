package io.leetcode.q200;

import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the
 * Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be
 * given as signed integer type and should not affect your implementation, as the internal binary representation
 * of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3
 * above the input represents the signed integer -3.
 *
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 */
@RunWith(LeetCodeRunner.class)
public class Q191_NumberOf1Bits {

    // you need to treat n as an unsigned value
    @Answer
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    // 利用了位运算中 n = n & (n-1) 可以清除 n 中最低位的1 的特性
    @Answer
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    // LeetCode 中最快的位数
    @Answer
    public int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create(0b00000000000000000000000000001011).expect(3);

    @TestData
    public DataExpectation example2 = DataExpectation.create(0b00000000000000000000000010000000).expect(1);

    @TestData
    public DataExpectation example3 = DataExpectation.create(0b11111111111111111111111111111101).expect(31);

}
