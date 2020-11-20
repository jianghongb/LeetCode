package com.leetcode.array;

import java.util.Arrays;

/**
 *
 */
public class RunningSum1480 {

  public static int[] runningSum2(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new ArrayIndexOutOfBoundsException("This array is empty");
    }
    for (int i = nums.length - 1; i > 0; i--) {
      int sum = nums[i];
      for (int j = i - 1; j >= 0; j--) {
        sum += nums[j];
      }
      nums[i] = sum;
    }
    return nums;
  }

  public static int[] runningSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new ArrayIndexOutOfBoundsException("This array is empty");
    }

    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }
    return nums;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 2, 3, 4 };
    runningSum(nums);
    Arrays.stream(nums).forEach(item -> System.out.println(item));
  }
}
