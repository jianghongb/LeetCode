package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * ou are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
 *
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2
 */
public class NextGreaterElementI {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0) {
      return nums1;
    }

    int[] resultArray = new int[nums1.length];
    int flag = 0, max;
    for (int i = 0; i < nums1.length; i++) {
      max = 0;
      flag = 0;
      for (int j = 0; j < nums2.length; j++) {
        if (nums2[j] == nums1[i])
          flag = 1;
        else if (flag == 1 && nums2[j] > nums1[i]) {
          max = nums2[j];
          break;
        }
      }
      resultArray[i] = max != 0 ? max : -1;
    }
    return resultArray;
  }

  public int[] nextGreaterElement2(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    for (int i = 0; i < findNums.length; i++) {
      findNums[i] = map.getOrDefault(findNums[i], -1);
    }
    return findNums;
  }

  public int[] nextGreaterElement3(int[] findNums, int[] nums) {
    int[] res = new int[findNums.length];
    Arrays.fill(res, -1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < findNums.length; i++) {
      map.put(findNums[i], i);

    }
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        if (map.containsKey(nums[stack.peek()])) {
          int idx = map.get(nums[stack.peek()]);
          res[idx] = nums[i];
        }
        stack.pop();
      }
      stack.push(i);
    }
    return res;
  }

  @Test
  void test() {
    int[] nums1 = { 4, 1, 2 };
    int[] nums2 = { 1, 3, 4, 2 };
    int[] result = nextGreaterElement3(nums1, nums2);
    for (int i : result) {
      System.out.print(i + ", ");

    }
  }
}
