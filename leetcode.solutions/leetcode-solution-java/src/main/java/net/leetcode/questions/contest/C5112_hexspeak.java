package net.leetcode.questions.contest;

import java.math.BigInteger;
import net.leetcode.questions.array.Q0027_remove_element;

/**
 * @author liweiwei1419
 * @date 2019/12/1 12:49 上午
 */
public class C5112_hexspeak {

    public String toHexspeak(String num) {
        // 首先将它变成字母大写的十六进制字符串
        String hexString = new BigInteger(num,10).toString(16);
        int len = hexString.length();
        for (int i = 0; i < len; i++) {
            int curNum = hexString.charAt(i) - '0';
            if (curNum > 1 && curNum < 10) {
                return "ERROR";
            }
        }

        return hexString.replace('0', 'O')
                .replace('1', 'I')
                .toUpperCase();
    }

    public static void main(String[] args) {
        String num = "619879596177";
        Q0027_remove_element solution = new Q0027_remove_element();
        String res = solution.toHexspeak(num);
        System.out.println(res);
    }
}
