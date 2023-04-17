package net.leetcode.questions.greedy;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0012_integer_to_roman1 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int times = num / nums[index];
            while (times > 0) {
                stringBuilder.append(romans[index]);
                times--;
            }
            num = num % nums[index];
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int num = 2845;
        String intToRoman = solution2.intToRoman(num);
        System.out.println(intToRoman);

        num = 1994;
        intToRoman = solution2.intToRoman(num);
        System.out.println(intToRoman);
    }
}
