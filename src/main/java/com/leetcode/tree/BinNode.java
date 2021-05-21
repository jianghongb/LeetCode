package com.leetcode.tree;

import java.util.Stack;

public class BinNode {

  public TreeNode convertBiNode(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode newRoot = new TreeNode(0), tmp = newRoot;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      root.left = null;
      tmp.right = root;
      tmp = root;
      root = root.right;
    }

    return newRoot.right;
  }

  public TreeNode convertBiNode2(TreeNode root) {
    TreeNode pre = new TreeNode(0);
    inOrder(root, pre);
    return pre.right;
  }

  private TreeNode inOrder(TreeNode root, TreeNode prev) {
    if (root != null) {
      prev = inOrder(root.left, prev);
      root.left = null;
      prev.right = root;
      prev = root;
      prev = inOrder(root.right, prev);
    }
    return prev;
  }

}
