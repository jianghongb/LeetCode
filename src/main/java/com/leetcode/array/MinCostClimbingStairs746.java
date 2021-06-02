package com.leetcode.array;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 *
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 *
 *
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs746 {

  public int minCostClimbingStairs(int[] cost) {

    if (cost == null || cost.length == 0) {
      throw new IllegalArgumentException();
    }

    int dp1 = 0, dp2 = 0;

    for (int i = 2; i < cost.length; i++) {
      int tmp = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
      dp2 = dp1;
      dp1 = tmp;
    }
    return dp1;
  }

  public int minCostClimbingStairs2(int[] cost) {
    // The array's length should be 1 longer than the length of cost
    // This is because we can treat the "top floor" as a step to reach
    int minimumCost[] = new int[cost.length + 1];

    // Start iteration from step 2, since the minimum cost of reaching
    // step 0 and step 1 is 0
    for (int i = 2; i < minimumCost.length; i++) {
      int takeOneStep = minimumCost[i - 1] + cost[i - 1];
      int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
      minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
    }

    // The final element in minimumCost refers to the top floor
    return minimumCost[minimumCost.length - 1];
  }
}
