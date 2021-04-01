package com.leetcode.tree;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 *
 * Return the total sum of all root-to-leaf numbers.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 * 1
 * / \
 * 2   3
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 *
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRoottoLeafNumbers129 {

  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  public int sum(TreeNode node, int sum) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return sum * 10 + node.val;
    }
    return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
  }

  /**
   * 我写的方法 可以改进为上面的实例
   *
   * @param root
   * @return
   */
  public int sumNumbers2(TreeNode root) {
    return sum2(root, 0);
  }

  public int sum2(TreeNode node, int sum) {
    if (node == null) {
      return sum;
    }
    if (node.left == null) {
      return sum(node.right, sum * 10 + node.val);
    }
    if (node.right == null) {
      return sum(node.left, sum * 10 + node.val);
    }
    return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
  }
}
