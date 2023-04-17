package net.leetcode.questions.stack;

import java.util.List;

public interface NestedInteger {
  /**
   * 这一项是否是一个整形
   *
   * @return
   */
  boolean isInteger();

  /**
   * @return 如果 isInteger() 返回 true，就可以返回这个数字
   */
  Integer getInteger();

  List<NestedInteger> getList();
}