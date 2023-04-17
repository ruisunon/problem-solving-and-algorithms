package net.leetcode.questions.binary_search;

public class VersionControl1 {
  boolean isBadVersion(int version) {
    // 为了本地编译通过，硬编码
    if (version < 13) {
      return false;
    }
    return true;
  }
}
