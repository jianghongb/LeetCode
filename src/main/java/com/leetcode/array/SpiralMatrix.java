package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix =
 * [[1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

  //边界处理有问题
  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();
    if (null == matrix || matrix.length == 0) {
      return res;
    }

    int lengthX = matrix.length;
    int lengthY = matrix[0].length;

    if (lengthX == 1) {
      for (int j = 0; j < lengthY; j++) {
        res.add(matrix[0][j]);
      }
      return res;
    }
    if (lengthY == 1) {
      for (int i = 0; i < lengthX; i++) {
        res.add(matrix[i][0]);
      }
      return res;
    }
    int loop = Math.min(lengthX, lengthY) / 2;
    int startX = 0, startY = 0;
    int offset = 1;
    while (loop > 0) {
      int i = startX, j = startY;

      for (; j < startY + lengthY - offset; j++) {
        res.add(matrix[i][j]);
      }

      for (; i < startX + lengthX - offset; i++) {
        res.add(matrix[i][j]);
      }

      for (; j > startY; j--) {
        res.add(matrix[i][j]);
      }

      for (; i > startX; i--) {
        res.add(matrix[i][j]);
      }

      loop--;
      startX++;
      startY++;
      offset += 2;
    }
    if (lengthX <= lengthY) {
      for (int j = lengthX / 2; j < lengthY - 1; j++) {
        res.add(matrix[lengthX / 2][j]);
      }
    }
    return res;
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0)
      return ans;
    int R = matrix.length, C = matrix[0].length;
    boolean[][] seen = new boolean[R][C];
    int[] dr = { 0, 1, 0, -1 };
    int[] dc = { 1, 0, -1, 0 };
    int r = 0, c = 0, di = 0;
    for (int i = 0; i < R * C; i++) {
      ans.add(matrix[r][c]);
      seen[r][c] = true;
      int cr = r + dr[di];
      int cc = c + dc[di];
      if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
        r = cr;
        c = cc;
      } else {
        di = (di + 1) % 4;
        r += dr[di];
        c += dc[di];
      }
    }
    return ans;
  }

  public List<Integer> spiralOrder3(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0) {
      return ans;
    }
    int r1 = 0, r2 = matrix.length - 1;
    int c1 = 0, c2 = matrix[0].length - 1;
    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) {
        ans.add(matrix[r1][c]);
      }
      for (int r = r1 + 1; r <= r2; r++) {
        ans.add(matrix[r][c2]);
      }
      if (r1 < r2 && c1 < c2) {
        for (int c = c2 - 1; c > c1; c--) {
          ans.add(matrix[r2][c]);
        }
        for (int r = r2; r > r1; r--) {
          ans.add(matrix[r][c1]);
        }
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return ans;
  }

  @Test
  void test() {
    int[][] nums = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    //    int[][] nums = { { 1 } };
    System.out.println(spiralOrder(nums));
    //    [1,2,3,4,8,12,11,10,9,5,6,7]
  }
}
