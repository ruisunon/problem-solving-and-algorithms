package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * Created by liwei on 17/9/23.
 */
public class Q0344_reverse_string1 {
    public String reverseString(String s) {
        char[] cArray = s.toCharArray();
        int i = 0;
        int j = cArray.length - 1;
        while (i < j) {
            swap(cArray, i, j);
            i++;
            j--;
        }
        return new String(cArray);
    }

    private void swap(char[] s, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        String result = solution.reverseString("hello world");
        System.out.println(result);
    }
}
