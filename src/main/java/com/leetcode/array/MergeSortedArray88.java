package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray88 {

  /**
   * Search two list from the end to start, compare and put the bigger num in the end index of nums1
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    if (nums1 == null || nums1.length == 0) {
      throw new IllegalArgumentException();
    }
    if (nums2 == null || nums2.length == 0) {
      return;
    }
    int index = m + n - 1;
    int i = m - 1, j = n - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[index--] = nums1[i--];
      } else {
        nums1[index--] = nums2[j--];
      }
    }
    while (j >= 0) {
      nums1[index--] = nums2[j--];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = { 0, 0 };
    int m = 0;
    int[] nums2 = { 1, 2 };
    int n = 2;
    merge(nums1, m, nums2, n);
    Arrays.stream(nums1).forEach(System.out::println);
  }
}
