package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 */
public class ContainsDuplicate217 {

  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int idx : nums) {
      if (map.get(idx) != null) {
        return true;
      }
      map.put(idx, idx);
    }
    return false;
  }

  public boolean containsDuplicate2(int[] nums) {
    if (nums.length < 2) {
      return false;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  @Test
  void test() {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(containsDuplicate(nums));
  }
}
