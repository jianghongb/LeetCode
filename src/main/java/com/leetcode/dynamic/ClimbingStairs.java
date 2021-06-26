package com.leetcode.dynamic;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {

  public int climbStairs(int n) {
    return climb_Stairs(0, n);
  }

  public int climb_Stairs(int i, int n) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
  }

  public int climbStairs3(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int climbStairs2(int n) {
    int[] memo = new int[n + 1];
    return climb_Stairs(0, n, memo);
  }

  public int climb_Stairs(int i, int n, int[] memo) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    return memo[i];
  }

  /**
   * 动态规划 求排列
   *
   * @param n
   * @return
   */
  public int climbStairs4(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 2; j++) {
        if (i >= j) {
          dp[i] += dp[i - j];
        }
      }
    }
    return dp[n];
  }
}
