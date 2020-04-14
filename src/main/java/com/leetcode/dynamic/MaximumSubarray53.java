package com.leetcode.dynamic;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray53 {

    /**
     * The question insists on contiguous subarray, which includes both positive and negative numbers, so you can think of some considerations:
     *
     *     When adding a new number, the sum can be either increasing or decreasing.
     *     In case of sum increasing, compare with current max to keep track of max sum.
     *     In case of sum decreasing, then we need to compare with current number.
     *         If sum is smaller than current number, then the new subarray starting with it is what we're looking for. Comparing sum with current max.
     *         If sum is greater than current number, nothing to do.
     *
     * Algorithm
     * With that in mind, drafting an algorithm:
     *
     *     If nums.length == 0, zero sum.
     *     If nums.length == 1, return the only number.
     *     Need two variables and initialize with first element of array, sum = nums[0], and max = nums[0].
     *     Process the iteration, nums[i] starting with i = 1.
     *     a. Compute the sum: sum += nums[i].
     *     b. If sum < nums[i], meaning sum decreasing, reset it, sum = nums[i].
     *     c. If max < sum, then max = sum. After every step, always confirm if max >= sum.
     *     Return max.
     */
    public int maxSubArray(int[] nums) {

        int sum = 0;
        if (null == nums || nums.length == 0) {
            return sum;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;

    }
}
