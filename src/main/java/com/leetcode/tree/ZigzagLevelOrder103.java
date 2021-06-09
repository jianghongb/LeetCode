package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    boolean flag = true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      flag = !flag;
      TreeNode cur = null;
      for (int i = 0; i < size; i++) {
        cur = queue.poll();
        if (cur != null) {
          list.add(cur.val);
          queue.offer(cur.left);
          queue.offer(cur.right);
        }
      }
      if (!list.isEmpty()) {
        if (flag) {
          Collections.reverse(list);
        }
        res.add(list);
      }
    }

    return res;
  }

  // dfs recursively
  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    dfs(root, 0, ret);
    return ret;
  }

  private void dfs(TreeNode node, int l, List<List<Integer>> ret) {
    if (node != null) {
      if (l == ret.size()) {
        List<Integer> level = new ArrayList<>();
        ret.add(level);
      }
      if (l % 2 == 1) {
        ret.get(l).add(0, node.val);  // insert at the beginning
      } else {
        ret.get(l).add(node.val);
      }
      dfs(node.left, l+1, ret);
      dfs(node.right, l+1, ret);
    }
  }

}
