package com.leetcode.tree;

import org.junit.jupiter.api.Test;

/**
 * Medium
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 * 2
 * / \
 * 1   3
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree98 {

  public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
  }

  public boolean isValid(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.val <= min) {
      return false;
    }
    if (max != null && root.val >= max) {
      return false;
    }
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
  }
  private Integer prev;

  /**
   * 通過中序遍歷實現
   *
   * @param root
   * @return
   */
  public boolean isValidBSTInOrder(TreeNode root) {
    prev = null;
    return inorder(root);
  }

  private boolean inorder(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!inorder(root.left)) {
      return false;
    }
    if (prev != null && root.val <= prev) {
      return false;
    }
    prev = root.val;
    return inorder(root.right);
  }
  @Test
  void test() {
    TreeNode treeNode = new TreeNode(5);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode7 = new TreeNode(7);

    treeNode.left = treeNode4;
    treeNode.right = treeNode6;
    treeNode6.left = treeNode3;
    treeNode6.right = treeNode7;
    System.out.println(isValidBST(treeNode));
  }
}
