package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 * 1
 * / \
 * 2   3
 * \   \
 * 5   4
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 * 1
 * \
 * 3
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Example 4:
 * 1
 * /
 * 2
 * Input: root = [1,2]
 * Output: [1,2]
 */
public class BinaryTreeRightSideView199 {

  /**
   * 队列实现
   *
   * @param root
   * @return
   */
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode curr = null;
      for (int i = 0; i < size; i++) {
        curr = queue.poll();
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      res.add(curr.val);
    }
    return res;
  }

  /**
   * 递归实现
   */
  List<Integer> res;

  public List<Integer> rightSideView(TreeNode root) {
    res = new ArrayList<>();
    if (root == null)
      return res;
    helper(root, 0);
    return res;
  }

  public void helper(TreeNode root, int lv) {
    // Assume there are four nodes at the same level, then from the right side of
    // view, the order of node seen from the right is:
    // right.right > right.left, left.right, left.left
    // which makes this question solvable by a recursive function
    int level = lv + 1;
    if (res.size() < level)
      res.add(root.val);
    if (root.right != null) {
      helper(root.right, level);
    }
    if (root.left != null) {
      helper(root.left, level);
    }
  }

}
