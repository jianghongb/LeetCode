package com.leetcode.search;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/binary-search/
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -9999 <= nums[i], target <= 9999
 * All the integers in nums are unique.
 * nums is sorted in an ascending order.
 */
public class BinarySearch {

  public int search(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
      return -1;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] > target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  @Test
  void test() {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 9;
    System.out.println(search(nums, target));
  }

}
