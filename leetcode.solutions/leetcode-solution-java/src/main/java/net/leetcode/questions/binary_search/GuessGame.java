package net.leetcode.questions.binary_search;

public class GuessGame {

  private static final int NUM = 6;

  int guess(int num) {
    if (num == NUM) {
      return 0;
    } else if (num < NUM) {
      return -1;
    }
    return 1;
  }
}