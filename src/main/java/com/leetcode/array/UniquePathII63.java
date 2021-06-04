package com.leetcode.array;

import org.junit.jupiter.api.Test;

public class UniquePathII63 {

  /**
   * dfs 超时
   *
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    return dfs(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
  }

  private int dfs(int[][] obstacleGrid, int i, int j, int m, int n) {

    if (i > m || j > n) {
      return 0;
    }
    if (obstacleGrid[i][j] == 1) {
      return 0;
    }
    if (i == m && j == n) {
      return 1;
    }
    return dfs(obstacleGrid, i + 1, j, m, n) + dfs(obstacleGrid, i, j + 1, m, n);
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    // 第一行如果有一个障碍都不能设值为1
    for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
      dp[i][0] = 1;
    }
    // 第一列如果有一个障碍都不能设值为1
    for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          continue;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

      }
    }
    return dp[m - 1][n - 1];
  }

  @Test
  void test() {

    int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    System.out.println(uniquePathsWithObstacles(obstacleGrid));

  }
}
