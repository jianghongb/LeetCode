package com.leetcode.weibag;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CoinChange322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    printDp(dp);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {

        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
      }
      printDp(dp);
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  public int coinChange2(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j <= amount; j++) {
        if (j >= coins[i]) {
          dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  private void printDp(int[] dp) {
    for (int i : dp) {
      System.out.print(i + ",");

    }
    System.out.println();
  }

  @Test
  void test() {
    int amount = 11;
    int[] conins = { 1, 2, 5 };
    System.out.println(coinChange(conins, amount));
  }
}
