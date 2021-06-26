package com.leetcode.weibag;

import org.junit.jupiter.api.Test;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
public class CoinChangeII518 {

  public int change(int amount, int[] coins) {

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] += dp[j - coins[i]];
      }
      printDp(dp);
    }
    return dp[amount];

  }

  public int change2(int amount, int[] coins) {

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int j = 0; j <= amount; j++) {
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] <= j) {
          dp[j] += dp[j - coins[i]];
        }
      }
      printDp(dp);
    }
    return dp[amount];

  }

  private void printDp(int[] dp) {
    for (int i :
        dp) {
      System.out.print(i + ",");

    }
    System.out.println();
  }

  @Test
  void test() {
    int amount = 5;
    int[] conins = { 1, 2, 5 };
    System.out.println(change2(amount, conins));
  }
}
