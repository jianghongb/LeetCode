package com.leetcode.array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DeleteAllX {

  public int[] deleteAllX(int[] nums, int x) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == x) {
        k++;
      } else {
        nums[i - k] = nums[i];
      }
    }
    return Arrays.copyOf(nums, nums.length-k);
  }

  @Test
  void test() {
    int[] nums = { 1, 2, 3, 4, 5, 3, 4 };
    int x = 3;
    int[] res = deleteAllX(nums, x);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i] + ".");
    }
  }
}
