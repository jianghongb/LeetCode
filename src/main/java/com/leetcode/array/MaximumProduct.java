package com.leetcode.array;

import java.util.Arrays;

public class MaximumProduct {

  /**
   * Using sorting
   *
   * Thus, either the product nums[0]×nums[1]×nums[n−1] or nums[n−3]×nums[n−2]×nums[n−1] will give the required result.
   * Thus, we need to find the larger one from out of these values.
   *
   * @param nums
   * @return
   */
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
        nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
  }

  /**
   * We need not necessarily sort the given nums array to find the maximum product.
   * Instead, we can only find the required 2 smallest values(min1
   * and min2) and the three largest values(max1,max2,max3) in the nums array,
   * by iterating over the nums array only once.
   *
   * At the end, again we can find out the larger value out of min1×min2×max1 and max1×max2×max3 to find the required maximum product.
   *
   * @param nums
   * @return
   */
  public int maximumProduct2(int[] nums) {
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    for (int n: nums) {
      if (n <= min1) {
        min2 = min1;
        min1 = n;
      } else if (n <= min2) {     // n lies between min1 and min2
        min2 = n;
      }
      if (n >= max1) {            // n is greater than max1, max2 and max3
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (n >= max2) {     // n lies betweeen max1 and max2
        max3 = max2;
        max2 = n;
      } else if (n >= max3) {     // n lies betwen max2 and max3
        max3 = n;
      }
    }
    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }
}
