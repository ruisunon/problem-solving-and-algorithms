package net.leetcode.questions.array;

import java.util.Random;

public class Q0912_sort_an_array5 {

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();


    // 快速排序

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        // 循环不变量：
        // all in [left + 1, lt) <= pivot
        // all in (gt, right] >= pivot
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt > gt) {
                break;
            }

            // 细节：相等的元素通过交换，等概率分到数组的两边
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
