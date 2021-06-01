package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int left = i + 1, right = nums.length - 1;
      if (nums[i] > 0) {
        return res;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      while (right > left) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (right > left && nums[right] == nums[right - 1]) {
            right--;
          }
          while (right > left && nums[left] == nums[left + 1]) {
            left++;
          }
          right--;
          left++;
        }
      }
    }
    return res;
  }

  @Test
  void test(){
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> lists = threeSum(nums);
    lists.forEach(integers -> {
      System.out.println(integers);
    });
  }
}
