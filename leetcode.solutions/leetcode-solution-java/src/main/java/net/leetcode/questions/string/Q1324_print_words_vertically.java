package net.leetcode.questions.string;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1324_print_words_vertically {

    public List<String> printVertically(String s) {
        String[] splitArr = s.split(" ");
        int len = splitArr.length;

        int maxLen = 0;
        for (String str : splitArr) {
            maxLen = Math.max(maxLen, str.length());
        }

        char[][] matrix = new char[len][maxLen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < splitArr[i].length(); j++) {
                matrix[i][j] = splitArr[i].charAt(j);
            }
        }

        char[][] transpose = transpose(matrix);
        List<String> res = new ArrayList<>(transpose.length);

        for (int i = 0; i < transpose.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < transpose[i].length; j++) {
                if (transpose[i][j] >= 'A' && transpose[i][j] <= 'Z') {
                    stringBuilder.append(transpose[i][j]);
                } else {
                    stringBuilder.append(' ');
                }

            }

            String s1 = stringBuilder.toString();
            res.add(s1.replaceAll("[ ]*$",""));
        }
        return res;
    }

    private char[][] transpose(char[][] A) {
        int row = A.length;
        if (row == 0) {
            return new char[0][0];
        }
        int col = A[0].length;
        char[][] matrix = new char[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[j][i] = A[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        // String s = "HOW ARE YOU";
        String s = "TO BE OR NOT TO BE";
        // String s = "CONTEST IS COMING";
        List<String> res = solution.printVertically(s);
        System.out.println(res);
    }
}
