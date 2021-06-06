package com.leetcode.weibag;

import org.junit.jupiter.api.Test;

public class CanPartition416 {

  public boolean canPartition(int[] nums) {

    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];

    for (int i = 0; i <= target; i++) {
      System.out.print(i + ", ");
    }
    System.out.println();
    for (int i = 0; i < nums.length; i++) {
      for (int j = target; j >= nums[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
      }
      print(dp);
    }
    return dp[target] == target;

  }

  private void print(int[] dp) {
    for (int i : dp) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }

  public boolean canPartition2(int[] nums) {
    int len = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if ((sum & 1) == 1) {
      return false;
    }
    System.out.println("here");
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    if (nums[0] <= target) {
      dp[nums[0]] = true;
    }
    for (int i = 1; i < len; i++) {
      for (int j = target; nums[i] <= j; j--) {
        if (dp[target]) {
          return true;
        }
        System.out.println(j + " ," + nums[i] + " ," + dp[j] + " ," + dp[j - nums[i]]);
        dp[j] = dp[j] || dp[j - nums[i]];
      }
    }
    return dp[target];

  }

  @Test
  void test() {
    int[] nums = { 1, 5, 11, 5 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;
    System.out.println(canPartition(nums));
  }
}
