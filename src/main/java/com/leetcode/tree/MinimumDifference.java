package com.leetcode.tree;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 */
public class MinimumDifference {

  Integer prev;
  int minDiff = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (prev != null) {
      minDiff = Math.min(minDiff, Math.abs(root.val - prev));
    }
    prev = root.val;
    inorder(root.right);
  }
}
