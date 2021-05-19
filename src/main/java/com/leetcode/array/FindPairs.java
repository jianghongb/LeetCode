package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 *
 * Notice that |val| denotes the absolute value of val.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * Example 4:
 *
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 *
 * Example 5:
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class FindPairs {

  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return -1;
    }
    Map<Integer, Integer> pairs = new HashMap<>();
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (Math.abs(nums[i] - nums[j]) == k && !pairs.containsKey(Math.min(nums[i], nums[j]))) {
          pairs.put(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j]));
          result++;
        }
      }
    }

    return result;
  }

  /**
   * 排序后 通过滑动窗口的形式计算
   *
   * @param nums
   * @param k
   * @return
   */
  public int findPairs2(int[] nums, int k) {
    Arrays.sort(nums); // 这个很重要
    int i = 0, j = 1, result = 0;
    while (i < nums.length && j < nums.length) {
      if (i == j || nums[j] - nums[i] < k) {
        j++;
      } else if (nums[j] - nums[i] > k) {
        i++;
      } else {
        result++;
        i++;
        while (i < nums.length && nums[i] == nums[i - 1]) {
          i++;
        }
      }
    }
    return result;
  }

  public int findPairs3(int[] nums, int k) {

    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int x : map.keySet()) {
      if ((k > 0 && map.containsKey(x + k)) || (k == 0 && map.get(x) > 1)) {
        count++;
      }
    }
    return count;
  }

  @Test
  void test() {
    int[] nums = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
    int k = 3;
    System.out.println(findPairs2(nums, k));
  }
}
