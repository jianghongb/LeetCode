package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 46. Permutations
 * Medium
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permutate(nums, result, 0, nums.length - 1);
    return result;
  }

  private void permutate(int[] nums, List<List<Integer>> result, int start, int end) {
    if (start == end) {
      List<Integer> list = new ArrayList<Integer>();
      for (int n : nums) {
        list.add(n);
      }
      result.add(list);
      return;
    }

    for (int i = start; i <= end; i++) {
      swap(nums, start, i);
      permutate(nums, result, start + 1, end);
      swap(nums, start, i); // restore previous state for the next permutation
    }
  }

  private void swap(int[] nums, int i, int j) {
    if (i == j) {
      return;
    }
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    dfs(output, new ArrayList<>(), nums);
    return output;
  }

  public void dfs(List<List<Integer>> output, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
      output.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (temp.contains(nums[i])) {
          continue;
        }
        temp.add(nums[i]);
        dfs(output, temp, nums);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<Integer>> permute3(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (null == nums || nums.length == 0) {
      return result;
    }
    List<Integer> ans = new ArrayList<>();
    permute(nums, ans, result);
    return result;
  }

  private void permute(int[] nums, List<Integer> ans, List<List<Integer>> result) {
    if (nums.length == ans.size()) {
      result.add(new ArrayList<>(ans));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (ans.contains(nums[i])) {
        continue;
      }
      ans.add(nums[i]);
      permute(nums, ans, result);
      ans.remove(ans.indexOf(nums[i]));
    }
  }

  @Test
  public void test() {
    int[] nums = { 1, 2, 3 };
    permute3(nums).stream().forEach(item -> System.out.println(item));
  }
}
