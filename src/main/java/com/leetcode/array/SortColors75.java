package com.leetcode.array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors75 {

    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }

    public void sortColors(int[] nums) {
        int writeIndex = 0;
        final int pivot = 1; // Hardcoded pivot.
        int n = nums.length - 1;

        // Scan from left to right to find elements less than the pivot (1).
        // If found, swap with the writeIndex and increase writeIndex
        // to point to the next available location.
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, writeIndex++);
            }
        }

        //                                           zeroesEnd  writeIndex
        //                                                |        |
        // Scan from right to zeroesEnd index. [ 0, 0, 0, 1, 2, 2, 1 ].
        // Try to find elements larger than the pivot, if found swap.
        // Place the writeIndex to the next available location.
        // Keep iterating until we reach the zeroesEnd.
        // We are sure that elements before zeroesEnd are already in their place.
        int zeroesEnd = writeIndex;
        writeIndex = n;
        for (int i = n; i >= zeroesEnd; --i) {
            if (nums[i] > pivot) {
                swap(nums, i, writeIndex--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
