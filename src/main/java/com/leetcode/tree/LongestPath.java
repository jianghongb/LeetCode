package com.leetcode.tree;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LongestPath {

  int result = 0;
  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {

    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    int aLeft = 0, aRight = 0;
    if (root.left != null && root.left.val == root.val) {
      aLeft = left + 1;
    }

    if (root.right != null && root.right.val == root.val) {
      aRight = right + 1;
    }
    result = Math.max(result, aLeft + aRight);
    return Math.max(aLeft, aRight);

  }

  @Test
  void test() {
    TreeNode root = new TreeNode(5);

    TreeNode l = new TreeNode(4);
    TreeNode r = new TreeNode(5);
    root.left = l;
    root.right = r;
    TreeNode ll = new TreeNode(1);
    TreeNode lr = new TreeNode(1);
    l.right = lr;
    l.left = ll;
    TreeNode rl = new TreeNode();
    TreeNode rr = new TreeNode(5);
    r.right = rr;

    System.out.println(longestUnivaluePath(root));
  }
}
