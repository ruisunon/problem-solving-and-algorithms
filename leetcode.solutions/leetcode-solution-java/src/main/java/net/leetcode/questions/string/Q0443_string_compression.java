package net.leetcode.questions.string;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0443_string_compression {

    // 这个版本是我自己写的，感觉代码不够优雅

    public int compress(char[] chars) {
        int len = chars.length;
        if (len < 2) {
            return len;
        }

        // write 指向下一个要写的索引位置

        int write = 0;
        // 当前重复的次数
        int duplicateTimes = 1;
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && chars[i] == chars[i + 1]) {
                duplicateTimes++;
            } else {
                // 如果遇到不同，就要结算
                // 当 i = len - 1 的时候同样也要结算
                chars[write] = chars[i];
                write++;
                // 如果只重复了 1 次，就不压缩
                if (duplicateTimes == 1) {
                    continue;
                }
                char[] timesArr = String.valueOf(duplicateTimes).toCharArray();
                for (char c : timesArr) {
                    chars[write] = c;
                    write++;
                }
                duplicateTimes = 1;
            }
        }
        // 调试代码
        printResult(chars, write);
        return write;
    }

    private void printResult(char[] chars, int iMax) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("压缩字符数组：");
        stringBuilder.append("[");

        for (int i = 0; ; i++) {
            stringBuilder.append(chars[i]);
            if (i == iMax - 1) {
                stringBuilder.append("]");
                break;
            }
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println("原始字符数组：" + Arrays.toString(chars));
        Q0027_remove_element solution = new Q0027_remove_element();
        int compress = solution.compress(chars);
        System.out.println(compress);
    }
}
