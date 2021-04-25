package com.leetcode.array;

import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class MinimumSizeSubarraySum {

  /**
   * 暴力解法
   *
   * @param target
   * @param nums
   * @return
   */
  public int minSubArrayLen1(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int result = Integer.MAX_VALUE;
    int sum = 0;
    int subLength = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum >= target) {
          subLength = j - i + 1;
          result = result < subLength ? result : subLength;
          break;
        }
      }
    }
    return result != Integer.MAX_VALUE ? result : 0;
  }

  /**
   * 滑动窗口：
   * 在本题中实现滑动窗口，主要确定如下三点：
   *
   * 窗口内是什么？
   * 如何移动窗口的起始位置？
   * 如何移动窗口的结束位置？
   * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
   * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
   * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
   *
   * 时间复杂度O(n) 空间复杂度O(1)
   *
   * @param target
   * @param nums
   * @return
   */
  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int result = Integer.MAX_VALUE;
    int sum = 0;
    int subLength = 0;
    int i = 0;

    for (int j = 0; j < nums.length; j++) {
      sum += nums[j];
      while (sum >= target) {
        subLength = j - i + 1;
        result = result < subLength ? result : subLength;
        sum -= nums[i++];
      }
    }
    return result != Integer.MAX_VALUE ? result : 0;
  }

  @Test
  void test() {

    int[] nums = { 2, 3, 1, 2, 4, 3 };
    int target = 7;
    System.out.println(minSubArrayLen(target, nums));
  }
}
