package com.leetcode.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 * 给定一棵二叉树的根，返回每个树节点倾斜的总和。
 * 树节点的倾斜是所有左子树节点值和所有右子树节点值的和之间的绝对差。如果一个节点没有左子节点，那么左子树节点值的和将被视为0。如果该节点没有右子节点，则规则类似。
 */
public class BinaryTreeTilt563 {

  int sum = 0;

  /**
   * 重新实现一下这个，思路需要理顺
   *
   * @param root
   * @return
   */
  public int findTilt(TreeNode root) {
    tilt(root);
    return sum;
  }

  private int tilt(TreeNode root) {
    if (root == null)
      return 0;
    int left = tilt(root.left);
    int right = tilt(root.right);

    sum += Math.abs(left - right);
    return left + right + root.val;
  }

  public int findTilt2(TreeNode root) {
    if (root == null)
      return 0;
    int tilt = 0;
    Stack<Integer> sums = new Stack<>();
    Stack<TreeNode> toVisit = new Stack<>();
    TreeNode calc = new TreeNode(0);
    toVisit.push(root);
    while (!toVisit.isEmpty()) {
      TreeNode node = toVisit.pop();
      if (node == calc) {
        int left = sums.pop(), right = sums.pop();
        tilt += Math.abs(left - right);
        sums.push(left + right + sums.pop());
        continue;
      }
      sums.push(node.val);
      toVisit.push(calc);
      if (node.left == null) {
        sums.push(0);
      } else {
        toVisit.push(node.left);
      }
      if (node.right == null) {
        sums.push(0);
      } else {
        toVisit.push(node.right);
      }
    }
    return tilt;
  }
}
