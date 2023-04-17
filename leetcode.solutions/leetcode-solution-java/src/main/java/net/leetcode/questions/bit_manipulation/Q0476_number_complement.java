package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0476_number_complement {

    /**
     * 使用 Java 库函数 Integer.toBinaryString() 将一个整数转换为二进制字符串表示
     * @param num
     * @return
     */
    public int findComplement(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("输入的数字不是正整数");
        }
        String numStr = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : numStr.toCharArray()) {
            if (c == '0') {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        numStr = stringBuilder.toString();
        return Integer.valueOf(numStr, 2);
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int n = 5;
        int solutionComplement = solution.findComplement(n);
        System.out.println(solutionComplement);
    }
}
