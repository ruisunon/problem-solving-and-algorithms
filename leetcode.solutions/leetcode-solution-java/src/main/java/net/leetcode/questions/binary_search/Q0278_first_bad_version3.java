package net.leetcode.questions.binary_search;



public class Q0278_first_bad_version3 extends VersionControl {

    /**
     * @param n n 是所有的版本数
     * @return 第一个出错的版本
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        // 1 2 3 4 4 4 4 4 4 4
        // 注意：这里是小于，不是等于
        while (left < right) {
            // 临近的时候靠左边，所以判断左边不是的时候，就一定要加上去
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
