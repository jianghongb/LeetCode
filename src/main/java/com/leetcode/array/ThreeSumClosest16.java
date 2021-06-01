package com.leetcode.array;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class ThreeSumClosest16 {

  public int threeSumClosest(int[] nums, int target) {
    int min = Integer.MAX_VALUE;

    if (nums == null || nums.length < 3) {
      return Integer.MIN_VALUE;
    }

    Arrays.sort(nums);
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {

      int left = i + 1, right = nums.length - 1;

      while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];
        int tmp = Math.min(min, Math.abs(sum - target));
        if (min > tmp) {
          min = tmp;
          res = sum;
        }
        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } /*else {
          // 注掉这段 影响效率
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }

          left++;
          right--;
        }*/
      }
    }

    return res;
  }

  /**
   * Algorithm
   *
   * 1. Initialize the minimum difference diff with a large value.
   * 2. Sort the input array nums.
   * 3. Iterate through the array:
   * * For the current position i, set lo to i + 1, and hi to the last index.
   * * While the lo pointer is smaller than hi:
   * ** Set sum to nums[i] + nums[lo] + nums[hi].
   * ** If the absolute difference between sum and target is smaller than the absolute value of diff:
   * *** Set diff to target - sum.
   * ** If sum is less than target, increment lo.
   * ** Else, decrement hi.
   * * If diff is zero, break from the loop.
   * 4. Return the value of the closest triplet, which is target - diff.
   *
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest2(int[] nums, int target) {
    int diff = Integer.MAX_VALUE, sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
      int lo = i + 1, hi = sz - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }
        if (sum < target) {
          ++lo;
        } else {
          --hi;
        }
      }
    }
    return target - diff;
  }

  @Test
  void test() {
    int[] nums = { -1, 2, 1, -4 };
    int res = threeSumClosest(nums, 1);
    System.out.println(res);
  }
}
