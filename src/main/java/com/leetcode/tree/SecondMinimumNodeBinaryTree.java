package com.leetcode.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 * Example 2:
 *
 * Input: root = [2,2,2]
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 25].
 * 1 <= Node.val <= 231 - 1
 * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 */
public class SecondMinimumNodeBinaryTree {

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    Set<Integer> res = new HashSet<>();
    inorder(root, res);

    int min1 = root.val;
    long ans = Long.MAX_VALUE;
    for (int v : res) {
      if (min1 < v && v < ans) {
        ans = v;
      }
    }
    return ans < Long.MAX_VALUE ? (int) ans : -1;
  }

  private void inorder(TreeNode node, Set<Integer> list) {
    if (node == null) {
      return;
    }
    list.add(node.val);
    inorder(node.left, list);
    inorder(node.right, list);
  }

  public int findSecondMinimumValue2(TreeNode root) {
    Set<Integer> uniques = new HashSet<Integer>();
    dfs(root, uniques);

    int min1 = root.val;
    long ans = Long.MAX_VALUE;
    for (int v : uniques) {
      if (min1 < v && v < ans) {
        ans = v;
      }
    }
    return ans < Long.MAX_VALUE ? (int) ans : -1;
  }

  public void dfs(TreeNode root, Set<Integer> uniques) {
    if (root != null) {
      uniques.add(root.val);
      dfs(root.left, uniques);
      dfs(root.right, uniques);
    }
  }
}
