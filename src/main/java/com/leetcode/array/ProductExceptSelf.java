package com.leetcode.array;

import org.junit.jupiter.api.Test;

public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {

    if (nums == null || nums.length == 0) {
      return nums;
    }

    int[] res = new int[nums.length];
    res[0] = 1;
    for (int i = 1; i < res.length; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    for (int j = nums.length - 1; j > 0; j--) {
      res[j] *= res[0];
      res[0] *= nums[j];
    }
    return res;
  }

  @Test
  void test() {
    int[] nums = { 1, 2, 3, 4 };
    int[] ints = productExceptSelf(nums);
    for (int i : ints) {
      System.out.print(i + ",");
    }
  }
}
