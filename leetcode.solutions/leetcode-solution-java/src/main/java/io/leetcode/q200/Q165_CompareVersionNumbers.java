package io.leetcode.q200;

import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
 * the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For example, version number
 * 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level
 * revision number are both 0.
 *
 *
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 *
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 *
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 *
 * Example 4:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 *
 * Example 5:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level
 * revision number is default to "0"
 *
 *
 *
 * Note:
 *
 * Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading
 * zeroes.
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
@RunWith(LeetCodeRunner.class)
public class Q165_CompareVersionNumbers {

    @Answer
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        for (int i = 0; i < Math.max(v1s.length, v2s.length); i++) {
            int v1 = i < v1s.length ? Integer.parseInt(v1s[i]) : 0;
            int v2 = i < v2s.length ? Integer.parseInt(v2s[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    @TestData
    public DataExpectation example1 = DataExpectation.createWith("0.1", "1.1").expect(-1);

    @TestData
    public DataExpectation example2 = DataExpectation.createWith("1.0.1", "1").expect(1);

    @TestData
    public DataExpectation example3 = DataExpectation.createWith("7.5.2.4", "7.5.3").expect(-1);

    @TestData
    public DataExpectation example4 = DataExpectation.createWith("1.01", "1.001").expect(0);

    @TestData
    public DataExpectation example5 = DataExpectation.createWith("1.0", "1.0.0").expect(0);

}
