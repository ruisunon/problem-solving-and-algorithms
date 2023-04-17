package net.leetcode.questions.binary_search;

/**
 * @author liweiwei1419
 * @date 2019/9/24 4:15 下午
 */
public class Q0374_guess_number_higher_or_lower1 extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // int mid = left + (right - left + 1) / 2;
            int mid = (left + right + 1) >>> 1;
            int guessNum = guess(mid);
            if (guessNum == -1) {
                // 目标数字小， mid 大
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 最后剩下的数一定是所求，无需后处理
        return left;
    }
}
