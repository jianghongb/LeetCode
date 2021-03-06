package com.leetcode.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths62 {

  public int uniquePaths(int m, int n) {

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  // DFS 暴力解法 ，但是超时了。。。。
  public int uniquePaths2(int m, int n) {
    return dfs(1, 1, m, n);
  }

  private int dfs(int i, int j, int m, int n) {
    if (i > m || j > n) {
      return 0;
    }

    if (i == m && j == n) {
      return 1;
    }
    return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
  }

  @Test
  void test() {
    int m = 3, n = 7;
    int uniquePaths = uniquePaths(m, n);
    System.out.println(uniquePaths);
    Assertions.assertEquals(28, uniquePaths);
  }
}
