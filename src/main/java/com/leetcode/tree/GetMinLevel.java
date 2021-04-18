package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class GetMinLevel {

  /**
   * 利用一个队列遍历二叉树,当遇到某层的某个节点其左右孩子都为NULL时候返回当前的层数,即为所求二叉数的最小深度；否则将当前的节点的左右孩子入队，重新遍历队列。
   * 当队列为空时候表明，当前层数的节点已经遍历完了，需要将 层数加一，即到新的一层遍历节点。
   *
   * @param root
   * @return
   */
  public int run(TreeNode root) {
    // write code here
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) { //当遇到叶子节点时，返回当前层数 此时为最
          return level;
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      level++;
    }
    return level;
  }

  public int run2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }
    int depth = Integer.MAX_VALUE;
    if (root.left != null) {
      depth = run(root.left);
    }
    if (root.right != null) {
      int temp = run(root.right);
      if (temp < depth) {
        depth = temp;
      }
    }
    return depth + 1;
  }
}
