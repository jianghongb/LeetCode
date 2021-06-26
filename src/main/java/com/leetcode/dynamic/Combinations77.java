package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations77 {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> tmp = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    if (n < 1 && k < 1) {
      return null;
    }
    backtracing(1, k, n);
    return res;
  }

  private void backtracing(int start, int k, int n) {

    if (tmp.size() == k) {
      res.add(new ArrayList<>(tmp));
      return;
    }

    for (int i = start; i <= n; i++) {
      tmp.add(i);
      backtracing(i + 1, k, n);
      tmp.remove((Integer) i);
    }
  }

  public List<List<Integer>> combine2(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(n, k, 1, new ArrayList<>(), res);
    return res;
  }

  private void dfs(int n, int k, int index, List<Integer> cur, List<List<Integer>> res) {
    if (cur.size() == k) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = index; i <= n; i++) {
      cur.add(i);
      dfs(n, k, i + 1, cur, res);
      cur.remove(cur.size() - 1);
    }
  }

  @Test
  void test() {
    int n = 4, k = 2;
    combine(n, k).stream().forEach(
        System.out::println
    );
  }
}
