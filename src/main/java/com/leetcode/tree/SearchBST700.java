package com.leetcode.tree;

public class SearchBST700 {

  public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }
    if (root.val < val) {
      return searchBST2(root.right, val);
    }
    return searchBST2(root.left, val);

  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }
    while (root != null) {
      if (root.val == val) {
        return root;
      }
      if (root.val > val) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return null;
  }

}
