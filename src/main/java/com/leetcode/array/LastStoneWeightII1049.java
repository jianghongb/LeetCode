package com.leetcode.array;

import org.junit.jupiter.api.Test;

public class LastStoneWeightII1049 {

  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int i : stones) {
      sum += i;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int i = 0; i < stones.length; i++) {
      for (int j = target; j >= stones[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
      }
    }
    return sum - 2 * dp[target];

  }

  @Test
  void test() {
    int[] stones = { 2, 7, 4, 1, 8, 1 };
    System.out.println(lastStoneWeightII(stones));
  }
}
