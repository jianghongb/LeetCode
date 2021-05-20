package com.leetcode.tree;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * 给定一个二叉树的根，返回树的直径的长度。
 * 二叉树的直径是树中任意两个节点之间最长路径的长度。此路径可能通过也可能不通过根。
 * 两个节点之间的路径长度由它们之间的边数表示。
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 */

// Definition for a binary tree node.

public class DiameterBinaryTree543 {

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    //Max dia b/w two nodes on left
    int l = diameterOfBinaryTree(root.left);
    //Max dia b/w two nodes on right
    int r = diameterOfBinaryTree(root.right);
    //Height of left & right node
    int lh = height(root.left);
    int rh = height(root.right);

    int tempAns = Math.max(l, r);
    int ans = Math.max(tempAns, lh + rh + 2);
    return ans;
  }

  int height(TreeNode root) {
    if (root == null)
      return -1;

    int l = height(root.left);
    int r = height(root.right);
    return Math.max(l, r) + 1;
  }

  int ans = 0;

  public int diameterOfBinaryTree2(TreeNode root) {
    if (root == null)
      return 0;
    solve(root);
    return ans;
  }

  private int solve(TreeNode root) {
    if (root == null)
      return -1;

    int left = solve(root.left);
    int right = solve(root.right);
    //Diameter from a node is the length on the left node+ right node +2(both egde inclusive)
    ans = Math.max(ans, left + right + 2);

    //Height of a node is the max b/w left & right node +1(one egde inclusive)
    return 1 + Math.max(left, right);

  }

  @Test
  void test() {
    TreeNode root = new TreeNode(1);

    TreeNode l = new TreeNode(2);
    TreeNode r = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    l.right = lr;
    l.left = ll;
    TreeNode rl = new TreeNode();
    TreeNode rr = new TreeNode(4);
    //    r.right = rr;
    root.left = l;
    root.right = r;

    System.out.print(diameterOfBinaryTree(root));
  }
}
