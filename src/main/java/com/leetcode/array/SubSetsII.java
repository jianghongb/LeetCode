package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class SubSetsII {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(result, nums, new ArrayList<>(), 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> subset, int idx) {
    result.add(new ArrayList<>(subset));
    Set<Integer> visited = new HashSet<>();
    for (int i = idx; i < nums.length; i++) {
      if (visited.add(nums[i])) {
        subset.add(nums[i]);
        backtrack(result, nums, subset, i + 1);
        subset.remove(subset.size() - 1);
      }
    }
  }

  /**
   *
   */
  @Test
  void test() {
    int[] nums = { 4, 4, 4, 1, 4 };
//    Arrays.stream(nums).forEach(System.out::print);
//    System.out.println();
    List<List<Integer>> subsets = subsetsWithDup(nums);
    subsets.stream().forEach(item -> {
      item.stream().forEach(System.out::print);
      System.out.println();
    });
  }
}
