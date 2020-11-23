package com.leetcode.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 */
public class SearchMatrix74 {

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
   * Memory Usage: 38.1 MB, less than 91.72% of Java online submissions for Search a 2D Matrix.
   * rightmost
   * 1. Loop through the matrix from up and right, checks if element in the matrix is smaller than target.
   * 2. If, smaller, move down
   * 3. If, larger , move left
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (null == matrix || matrix.length == 0) {
      return false;
    }
    int row = 0, col = matrix[0].length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] > target) {
        col--;
      } else {
        row++;
      }
    }
    return false;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
   * Memory Usage: 38.4 MB, less than 5.62% of Java online submissions for Search a 2D Matrix.
   *
   * 1. Loop through the matrix, checks if rightmost element in the matrix is smaller than target.
   * 2. If, smaller, we skip the current row iteration by j = col (break the loop)
   */
  public boolean searchMatrix2(int[][] matrix, int target) {
    if (matrix.length == 0)
      return false;
    int row = matrix.length, col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == target)
          return true;
        if (matrix[i][col - 1] < target)
          j = col;
      }
    }
    return false;
  }

  public boolean searchMatrix3(int[][] matrix, int target) {
    if (matrix.length == 0)
      return false;
    int m = matrix.length;
    int n = matrix[0].length;
    int l = 0;
    int r = m * n - 1;
    int mid;
    while (l <= r) {
      mid = (r - l) / 2 + l;
      int x = mid / n;
      int y = mid % n;
      if (matrix[x][y] == target) {
        return true;
      } else if (matrix[x][y] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }
}
