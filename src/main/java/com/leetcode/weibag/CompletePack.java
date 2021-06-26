package com.leetcode.weibag;

/**
 *
 */

public class CompletePack {

  // 先遍历物品，在遍历背包
  int test_CompletePack() {
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;
    int[] dp = new int[bagWeight + 1];
    for (int i = 0; i < weight.length; i++) { // 遍历物品
      for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    return dp[bagWeight];
  }

  // 先遍历背包，再遍历物品
  int test_CompletePack2() {
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;

    int[] dp = new int[bagWeight + 1];

    for (int j = 0; j <= bagWeight; j++) { // 遍历背包容量
      for (int i = 0; i < weight.length; i++) { // 遍历物品
        if (j - weight[i] >= 0) {
          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
      }
    }
    return dp[bagWeight];
  }
}
