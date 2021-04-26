package com.leetcode.array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [
 * [1,2,3],
 * [8,9,4],
 * [7,6,5]]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];

    // 循环次数
    int loop = n / 2;
    // 定义每次循环起始位置
    int startX = 0;
    int startY = 0;

    // 定义偏移量
    int offset = 1;
    // 定义填充数字
    int count = 1;
    // 定义中间位置
    int mid = n / 2;
    while (loop > 0) {
      int i = startX;
      int j = startY;

      // 模拟上侧从左到右
      for (; j < startY + n - offset; ++j) {
        res[startX][j] = count++;
      }

      // 模拟右侧从上到下
      for (; i < startX + n - offset; ++i) {
        res[i][j] = count++;
      }

      // 模拟下侧从右到左
      for (; j > startY; j--) {
        res[i][j] = count++;
      }

      // 模拟左侧从下到上
      for (; i > startX; i--) {
        res[i][j] = count++;
      }
      loop--;
      startX ++;
      startY += 1;
      offset += 2;
    }

    if (n % 2 == 1) {
      res[mid][mid] = count;
    }

    return res;
  }

  @Test
  void test() {
    Arrays.stream(generateMatrix(4)).forEach(nums -> {
      Arrays.stream(nums).forEach(System.out::print);
      System.out.println();
    });
  }
}
