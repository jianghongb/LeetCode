package com.leetcode.dynamic;

/**
 *
 */
public class DfsSolution {

  static int n = 3;
  static int a[] = new int[n + 1];
  static int book[] = new int[n + 1];

  static void dfs(int step) {

    if (step == n+1) {
      for (int i = 1; i <= n; i++) {
        System.out.print(a[i]);
      }
      System.out.println("\n");
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (book[i] == 0) {
        a[step] = i;
        book[i] = 1;
        dfs(step + 1);
        book[i] = 0;
      }
    }
  }

  public static void main(String[] args) {
    dfs(1);
  }
}
