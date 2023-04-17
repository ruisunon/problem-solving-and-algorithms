package leetcode.locked;

import java.util.List;

import leetcode.locked.common.NestedInteger;

public class NestedListWeighSumII364 {
    private int maxDepth(List<NestedInteger> nestedList, int depth) {
        int max = depth;
        for(NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                max = Math.max(max, maxDepth(ni.getList(), depth + 1));
            }
        }
        return max;
    }
    private int sum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += sum(ni.getList(), depth - 1);
            }
        }
        return sum;
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        int max = maxDepth(nestedList, 1);
        return sum(nestedList, max);
    }
}
