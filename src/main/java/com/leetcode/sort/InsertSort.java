package com.leetcode.sort;

public class InsertSort {

    public int[] insertSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int insertNote = 0;
        for (int i = 1; i < nums.length; i++) {
            insertNote = nums[i];
            int j = i - 1;
            while (j >= 0 && insertNote < nums[j]) {
                nums[j + 1] = nums[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            nums[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
        return nums;
    }
}
