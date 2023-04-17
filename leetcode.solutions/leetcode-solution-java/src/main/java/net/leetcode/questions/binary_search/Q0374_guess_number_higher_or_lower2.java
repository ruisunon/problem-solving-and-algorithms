package net.leetcode.questions.binary_search;

import net.leetcode.questions.array.Q0027_remove_element;



// 这道题题目的描述比较让人疑惑，能通过在线测评即可，不用深究

public class Q0374_guess_number_higher_or_lower2 extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q0374_guess_number_higher_or_lower2 solution = new Q0374_guess_number_higher_or_lower2();
        int n = 10;
        int guessNumber = solution.guessNumber(n);
        System.out.println(guessNumber);
    }
}


