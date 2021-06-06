package com.leetcode.weibag;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class WeightBagProblem01 {

  public int[][] weightBag(int[] weight, int[] value, int bagWeight) {
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
    return dp;
  }

  @Test
  void test() {
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;
    int[][] dp = weightBag(weight, value, bagWeight);
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j]);
      }
      System.out.println();
    }
    System.out.println(dp[dp.length - 1][dp[0].length - 1]);
  }

}
