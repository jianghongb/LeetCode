package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 * Example 4:
 *
 * Input: nums = [0]
 * Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
 *
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 */
public class MissingNumber {

  public int missingNumber(int[] nums) {

    if (nums == null || nums.length == 0) {
      return -1;
    }

    Integer[] res = new Integer[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      res[nums[i]] = nums[i];
    }

    for (int i = 0; i < res.length; i++) {
      if (res[i] == null) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Algorithm
   *
   * Because we know that nums contains nnn numbers and that it is missing exactly one number
   * on the range [0..n−1][0..n-1][0..n−1], we know that nnn definitely replaces the missing
   * number in nums. Therefore, if we initialize an integer to nnn and XOR it with every index
   * and value, we will be left with the missing number. Consider the following example
   * (the values have been sorted for intuitive convenience, but need not be):
   * Index 	0 	1 	2 	3
   * Value 	0 	1 	3 	4
   *
   * missing=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2=0∧0∧0∧0∧2=2
   *
   * @param nums
   * @return
   */
  public int missingNumber2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }

  public int missingNumber3(int[] nums) {
    int expectedSum = nums.length * (nums.length + 1) / 2;
    int actualSum = 0;
    for (int num : nums)
      actualSum += num;
    return expectedSum - actualSum;
  }

  @Test
  void test() {
    int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
    Assertions.assertEquals(8, missingNumber(nums));
  }
}
