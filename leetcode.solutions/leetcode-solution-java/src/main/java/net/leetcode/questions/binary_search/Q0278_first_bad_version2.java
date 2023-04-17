package net.leetcode.questions.binary_search;

public class Q0278_first_bad_version2 extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}