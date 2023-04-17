package net.leetcode.questions.greedy;

/**
 * @author liweiwei1419
 * @date 2019/10/29 2:01 下午
 */
public class Q0012_integer_to_roman2 {

    // 一位一位打表做

    public String intToRoman(int num) {
        // 个位
        String[] one = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 十位
        String[] two = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 百位
        String[] three = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 千位
        String[] four = new String[]{"", "M", "MM", "MMM"};
        return four[num / 1000] + three[(num / 100) % 10] + two[(num / 10) % 10] + one[num % 10];
    }
}
