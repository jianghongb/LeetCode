package com.leetcode.dynamic;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 5
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 19
 */
public class UniqueBinarySearchTree {

  public int numTrees(int n) {
    int[] M = new int[n + 1];
    M[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        M[i] += M[j] * M[i - j - 1];
      }
    }
    return M[n];
  }

  public int numTrees2(int n) {
    // DP
    // count all combinations of "left subtree + root + right subtree" in 1...n
    // { } keys space

    // n = 0 () (empty tree)
    // { } -> g(0) = 1 combination

    // n = 1 (1) (single root) -> # of unique BSTS - 1
    // { 1 } -> g(1) = 1 combination

    // n = 2 (1,2)
    // root: 1         2
    //      / \  or   / \
    //    { } {2}   {1} { }
    //    g0 * g1   g1 * g0 <--- cartesian product sets -> g(0)g(1) + g(1)g(0) = g(2) = 2

    // n = 3 (1,2,3)
    // root: 1           2         3
    //      / \   or    / \  or  /   \
    //    { } {2,3}   {1} {3}  {1,2} { }
    //     g0 * g2     g1*g1    g2 * g0    -> g(0)g(2) + g(1)g(1) + g(2)g(0) = 2 + 1 + 2 = 5
    // ....

    // catalan numbers G(n) = sum i=1..n G(i - 1) * G(n - i)
    int[] g = new int[n + 1];
    g[0] = 1;
    g[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < n; j++) {
        g[n] += g[j] * g[n - j - 1];
      }
    }

    return g[n];
  }
}
