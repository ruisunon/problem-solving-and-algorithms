package io.leetcode.q500;

import java.util.regex.Pattern;
import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/validate-ip-address/
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
 * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the
 * address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros
 * and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons
 * (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 *
 * Input: "172.16.254.1"
 *
 * Output: "IPv4"
 *
 * Explanation: This is a valid IPv4 address, return "IPv4".
 *
 * Example 2:
 *
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * Output: "IPv6"
 *
 * Explanation: This is a valid IPv6 address, return "IPv6".
 *
 * Example 3:
 *
 * Input: "256.256.256.256"
 *
 * Output: "Neither"
 *
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
@RunWith(LeetCodeRunner.class)
public class Q468_ValidateIPAddress {

    private static final Pattern IPV4 = Pattern.compile(
            "(?:(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])");

    private static final Pattern IPV6 = Pattern.compile(
            "(?:[0-9a-f]{1,4}:){7}[0-9a-f]{1,4}", Pattern.CASE_INSENSITIVE);

    // 挺无聊的一题, LeetCode 上最快的解法是代码方式进行字符串判断.
    @Answer
    public String validIPAddress(String IP) {
        if (IPV4.matcher(IP).matches()) {
            return "IPv4";
        }
        if (IPV6.matcher(IP).matches()) {
            return "IPv6";
        }
        return "Neither";
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create("172.16.254.1").expect("IPv4");

    @TestData
    public DataExpectation example2 = DataExpectation.create("2001:0db8:85a3:0:0:8A2E:0370:7334").expect("IPv6");

    @TestData
    public DataExpectation example3 = DataExpectation.create("256.256.256.256").expect("Neither");

}
