package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 *
 * Input: nums = [1,1]
 * Output: 1
 *
 * Example 4:
 *
 * Input: nums = [1,1,2]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 2 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 *
 *
 * Follow up:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem without modifying the array nums?
 * Can you solve the problem using only constant, O(1) extra space?
 * Can you solve the problem with runtime complexity less than O(n2)?
 */
public class FindDuplicateNumber {

  public int findDuplicate(int[] nums) {
    if (null == nums || nums.length == 0) {
      return -1;
    }

    int[] numList = new int[nums.length + 1];
    for (int num : nums) {
      numList[num]++;
      if (numList[num] > 1) {
        return num;
      }
    }

    return -1;
  }

  public int findDuplicate2(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      int val = Math.abs(nums[i]);
      if (nums[val] < 0) {
        return val;
      }
      nums[val] *= -1;
    }
    return 0;
  }

  @Test
  void test() {
    int[] nums = { 1, 3, 4, 2, 2 };
    Assertions.assertEquals(findDuplicate2(nums), 2);
    for (int num : nums) {
      System.out.print(num + ",");
    }
  }
}
