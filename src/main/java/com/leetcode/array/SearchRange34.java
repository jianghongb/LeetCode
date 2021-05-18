package com.leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class SearchRange34 {

  public int[] searchRange(int[] nums, int target) {

    int[] res = { -1, -1 };
    if (nums == null || nums.length == 0) {
      return res;
    }
    int lo = 0, hi = nums.length - 1;

    //lo is the start index of target
    //hi is the end index of target
    while (nums[lo] < nums[hi]) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > target) {//target is in the left half
        hi = mid - 1;
      } else if (nums[mid] < target) {// target is in the right half
        lo = mid + 1;
      } else {//find target, then need to find the start and end point
        if (nums[lo] == nums[mid]) {
          hi--;
        } else {
          lo++;
        }
      }
    }
    //check whether find the target number
    if (nums[lo] == nums[hi] && nums[lo] == target) {
      res[0] = lo;
      res[1] = hi;
    }
    return res;
  }

  public int[] searchRange(int[] A, int l, int r, int target) {
    int[] result = new int[] { -1, -1 };

    while (l <= r) {
      int mid = (l + r) / 2;

      if (A[mid] < target) {
        l = mid + 1;
      } else if (A[mid] > target) {
        r = mid - 1;
      } else {
        int[] left = searchRange(A, l, mid - 1, target);
        result[0] = left[0] == -1 ? mid : left[0];

        int[] right = searchRange(A, mid + 1, r, target);
        result[1] = right[1] == -1 ? mid : right[1];

        break;
      }
    }

    return result;
  }

  public int[] searchRange2(int[] A, int target) {
    return searchRange(A, 0, A.length - 1, target);
  }

  public int[] searchRange3(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirst(nums, target, 0, nums.length-1);
    result[1] = findLast(nums, target, 0, nums.length-1);
    return result;
  }

  private int findFirst(int[] nums, int target, int start, int end) {
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
      if (nums[mid] == target)
        idx = mid;
    }
    return idx;
  }

  private int findLast(int[] nums, int target,int start ,int end) {
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] <= target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      if (nums[mid] == target)
        idx = mid;
    }
    return idx;
  }

  @Test
  void test() {
    int[] nums = { 6, 6, 9 };
    int target = 6;
    int[] ints = searchRange(nums, target);
    System.out.println(ints[0] + " , " + ints[1]);
  }
}
