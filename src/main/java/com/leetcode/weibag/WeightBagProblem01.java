package com.leetcode.weibag;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class WeightBagProblem01 {

  public int weightBag(int[] weight, int[] value, int bagWeight) {
    int[][] dp = new int[weight.length][bagWeight + 1];

    for (int i = bagWeight; i >= weight[0]; i--) {
      dp[0][i] = dp[0][i - weight[0]] + value[0];
    }

    for (int i = 1; i < weight.length; i++) {
      for (int j = 0; j <= bagWeight; j++) {
        if (j < weight[i]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  public int weightBag2(int[] weight, int[] value, int bagWeight) {
    int[] dp = new int[bagWeight + 1];

    for (int i = 0; i < weight.length; i++) {
      for (int j = bagWeight; j >= weight[i]; j--) {
        System.out.println(dp[j] + " ," + (dp[j - weight[i]] + value[i]));
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);

      }
    }
    return dp[bagWeight];
  }

  @Test
  void test() {
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;
    System.out.println(weightBag2(weight, value, bagWeight));
  }

}
