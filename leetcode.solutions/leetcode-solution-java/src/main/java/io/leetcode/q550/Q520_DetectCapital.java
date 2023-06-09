package io.leetcode.q550;

import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/detect-capital/
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
@RunWith(LeetCodeRunner.class)
public class Q520_DetectCapital {

    @Answer
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        boolean isLowerCase = Character.isLowerCase(word.charAt(0))
                || Character.isLowerCase(word.charAt(1));
        for (int i = 1; i < word.length(); i++) {
            if (isLowerCase ^ Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create("USA").expect(true);

    @TestData
    public DataExpectation example2 = DataExpectation.create("FlaG").expect(false);

}
