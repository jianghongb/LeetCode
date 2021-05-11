package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */
public class FindDuplicates442 {

    /**
     * O(n) time and O(n+1) space
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] numList = new int[nums.length + 1];
        for (int num : nums) {
            numList[num]++;
            if (numList[num] > 1) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * O(n) time and O(1) space
     * 思路：
     *   当扫描到下标为i的数字时，获取当前数字的绝对值n = Math.abs(nums[i]),
     *   拿到以n-1为下标的数字，如果该下标对应的数字大于0 ，则将其变为负值；
     *   如果下标对应的数字小于零，则表示n为重复数字
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] < 0) {
                list.add(n);
            } else {
                nums[n - 1] = -nums[n - 1];
            }
        }
        return list;
    }

}
