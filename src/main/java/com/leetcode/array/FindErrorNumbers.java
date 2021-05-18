package com.leetcode.array;

/**
 * Easy
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class FindErrorNumbers {

  public int[] findErrorNums(int[] nums) {
    int len = nums.length;
    int[] arr = new int[len + 1];

    int dup = -1;
    int missing = 1;
    for (int n : nums) {
      arr[n]++;
    }

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == 0) {
        missing = i;
      } else if (arr[i] == 2) {
        dup = i;
      }
    }

    return new int[] { dup, missing };
  }

  public int[] findErrorNums2(int[] nums) {
    int dup = -1, missing = 1;
    for (int n : nums) {
      if (nums[Math.abs(n) - 1] < 0) {
        dup = Math.abs(n);
      } else {
        nums[Math.abs(n) - 1] *= -1;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        missing = i + 1;
      }
    }
    return new int[] { dup, missing };
  }
}