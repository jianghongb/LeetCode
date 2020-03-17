package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
public class FindNumbersNotInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == null) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbersFast(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return result;
        int max = nums.length;
        int[] numsList = new int[max + 1];
        // Build a array with num as index and show time as value
        for (int num : nums) {
            numsList[num]++;
        }
        for (int i = 1; i < numsList.length; i++) {
            if (numsList[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
