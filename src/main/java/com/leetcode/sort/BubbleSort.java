package com.leetcode.sort;

public class BubbleSort {

    // 最小泡排序，可以把if条件换为 nums[j+1] < nums[j] ,即最大泡排序
    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] > nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

}
