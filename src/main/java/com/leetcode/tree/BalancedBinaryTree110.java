package com.leetcode.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: root = []
 * Output: true
 */
public class BalancedBinaryTree110 {

  boolean balanced = true;

  /**
   * 这个实现不太好 因为 判断逻辑和获取树高在一个方法中
   *
   * @param root
   * @return
   */
  public boolean isBalanced2(TreeNode root) {
    if (root == null)
      return balanced;
    height2(root);
    return balanced;
  }

  int height2(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null) {
      return 1;
    }
    int left = height2(root.left);
    int right = height2((root.right));
    if (balanced) {
      balanced = Math.abs((left - right)) > 1;
      return Math.max(left, right) + 1;
    }
    return 0;
  }

  public boolean isBalanced(TreeNode root) {

    if (root == null)
      return true;

    int left = height(root.left);
    int right = height(root.right);
    if (Math.abs(left - right) > 1) {
      return false;
    } else {
      return isBalanced(root.left) && isBalanced(root.right);
    }
  }

  int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }
}
