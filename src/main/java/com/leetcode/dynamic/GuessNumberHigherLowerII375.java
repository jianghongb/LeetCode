package com.leetcode.dynamic;

import java.util.Arrays;

public class GuessNumberHigherLowerII375 {

  public int getMoneyAmount(int n) {
    if (n <= 1)
      return 0;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < n; i++) {
      dp[i][i] = 0;
    }

    int i = 0;
    int j = 1;
    int count = 1;
    while (true) {
      for (int k = i; k <= j; k++) {
        int one = (k + 1) + Math.max(((k - 1 >= i) ? dp[i][k - 1] : 0), ((k + 1 <= j) ? dp[k + 1][j] : 0));
        dp[i][j] = Math.min(dp[i][j], one);
      }
      i++;
      j++;
      if (j == n) {
        i = 0;
        j = ++count;
      }
      if (j == n) {
        break;
      }
    }
    return dp[0][n - 1];
  }
}
