package com.leetcode.weibag;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PerfectSquares279 {

  public int numSquares(int n) {
    if (n < 1) {
      return -1;
    }
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);
    dp[0] = 0;

    for (int i = 0; i * i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (j >= i * i) {
          dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
        }
      }
      printDp(dp);
    }
    return dp[n] == n + 1 ? -1 : dp[n];
  }

  private void printDp(int[] dp) {
    for (int i : dp) {
      System.out.print(i + ",");
    }
    System.out.println();
  }

  @Test
  void test() {
    int amount = 1;
    System.out.println(numSquares(amount));
  }
}
