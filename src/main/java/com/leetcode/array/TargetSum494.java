package com.leetcode.array;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum494 {

  /**
   * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247486709&idx=1&sn=75f1f43d96dbd1c5c3e281b8963e3c50&scene=21#wechat_redirect
   *
   * 时间复杂度O(n * m)，n为正数个数，m为背包容量
   * 空间复杂度：O(m) m为背包容量
   * @param nums
   * @param target
   * @return
   */
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum < target) {
      return 0;
    }
    if ((sum + target) % 2 == 1) {
      return 0;
    }

    int x = (sum + target) / 2;
    int[] dp = new int[x + 1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = x; j >= nums[i]; j--) {
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[x];
  }
}
