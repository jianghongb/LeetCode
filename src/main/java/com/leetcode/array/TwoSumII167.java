package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII167 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment) + 1, i + 1 };
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[] {};
    }


    public int[] twoSumBest(int[] numbers, int target) {
        int lo = 0, hi = numbers.length-1;

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[] { lo + 1, hi + 1 };
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[] {-1, -1};

    }

}
