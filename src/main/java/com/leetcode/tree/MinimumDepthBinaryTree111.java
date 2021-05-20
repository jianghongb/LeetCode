package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node
 * down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
public class MinimumDepthBinaryTree111 {

  /**
   * 使用递归的思路
   */
  int depth = 0;

  public int minDepth3(TreeNode root) {
    if (root == null) {
      return depth;
    }
    depth(root);
    return depth;
  }

  int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = depth(node.left);
    int right = depth(node.right);
    if (left == 0) {
      depth = right + 1;
    } else if (right == 0) {
      depth = left + 1;
    } else {
      depth = Math.min(left, right) + 1;
    }
    return depth;
  }

  /**
   * 借鉴层序遍历的思路
   *
   * @param root
   * @return
   */
  public int minDepth2(TreeNode root) {
    if (root == null)
      return 0;
    Queue<TreeNode> q = new LinkedList<>();
    int depth = 0;
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      ++depth;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left == null && node.right == null)
          return depth;
        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
      }
    }
    return depth;
  }

  /**
   * 第一个minDepth3的优化版本
   *
   * @param root
   * @return
   */
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    } else if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }

}
