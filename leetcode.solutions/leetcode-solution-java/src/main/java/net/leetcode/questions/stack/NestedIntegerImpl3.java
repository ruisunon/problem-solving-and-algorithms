package net.leetcode.questions.stack;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl3 implements NestedInteger {
  private boolean isInteger = false;
  private Integer intData;
  private List<NestedInteger> nestedList = new ArrayList<>();

  public NestedIntegerImpl3(boolean isInteger, Integer intData) {
    this.isInteger = isInteger;
    this.intData = intData;
  }

  public NestedIntegerImpl3(boolean isInteger, NestedInteger... nestedIntegers) {
    this.isInteger = false;
    for (NestedInteger nestedInteger : nestedIntegers) {
      this.nestedList.add(nestedInteger);
    }
  }

  @Override
  public boolean isInteger() {
    return isInteger;
  }

  @Override
  public Integer getInteger() {
    return intData;
  }

  @Override
  public List<NestedInteger> getList() {
    return nestedList;
  }
}