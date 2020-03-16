package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement169 {

    /**
     * Time complexity : O(nlgn)O(nlgn)O(nlgn)
     * Sorting the array costs O(nlgn)O(nlgn)O(nlgn) time in Python and Java, so it dominates the overall runtime.
     * Space complexity : O(1)O(1)O(1) or (O(n)O(n)O(n))
     * We sorted nums in place here - if that is not allowed, then we must spend linear additional space on a copy of nums and sort the copy instead.
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sorted = IntStream.of(nums)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .mapToInt(i -> i)
                .toArray();

        return sorted[sorted.length / 2];
    }

    public int majorityElementFaster(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElementMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2)
                return nums[i];
        }
        return -1;
    }
}
