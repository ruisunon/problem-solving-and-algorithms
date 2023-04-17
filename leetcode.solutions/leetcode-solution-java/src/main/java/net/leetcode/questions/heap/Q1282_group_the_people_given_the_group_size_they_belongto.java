package net.leetcode.questions.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1282_group_the_people_given_the_group_size_they_belongto {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();

        // 特判
        if (len == 0) {
            return res;
        }

        // 默认就是最小堆，int[] 的长度为 2，第 1 个数是数组元素，第 2 个数是数组索引
        // 其实就是把数和索引绑定在了一起，在堆中参与比较的是数，索引是依附于数的
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < len; i++) {
            minHeap.add(new int[]{groupSizes[i], i});
        }

        while (!minHeap.isEmpty()) {
            int curSize = minHeap.peek()[0];

            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                current.add(Objects.requireNonNull(minHeap.poll())[1]);
            }

            res.add(current);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        Q0027_remove_element solution = new Q0027_remove_element();
        List<List<Integer>> res = solution.groupThePeople(groupSizes);
        System.out.println(res);
    }
}
