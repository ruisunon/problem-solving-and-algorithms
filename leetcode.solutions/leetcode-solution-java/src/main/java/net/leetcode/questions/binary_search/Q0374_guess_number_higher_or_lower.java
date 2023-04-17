package net.leetcode.questions.binary_search;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0374_guess_number_higher_or_lower extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guessNum = guess(mid);
            if (guessNum == 0) {
                return mid;
            } else if (guessNum == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int n = 10;
        int guessNumber = solution2.guessNumber(n);
        System.out.println(guessNumber);
    }
}


