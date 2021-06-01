package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new NumberFormatException("No result found .");
    }

    public int[] twoSumFast(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    public int[] twoSum3(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return nums;
        }

        Arrays.sort(nums);
        int numIndex1 = 0, numIndex2 = -1;
        int i = 1;
        while(i < nums.length){
            numIndex2 = i;
            if((nums[numIndex1] + nums[numIndex2]) == target){
                return new int[]{numIndex1, numIndex2};
            }
            if((nums[numIndex1] + nums[numIndex2]) < target){
                numIndex1 = numIndex2;
            }
            i++;
        }
        return new int[]{};
    }

    @Test
    void test(){
        int[] nums = { 3,2,4 };
        int target = 6;
        for (int i : twoSum3(nums, target)) {
            System.out.println(i);
        }
    }
}
