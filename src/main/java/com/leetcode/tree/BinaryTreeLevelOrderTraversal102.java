package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.collections4.CollectionUtils;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * 3
 * / \
 * 9  20
 * / \
 * 15  7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 */
public class BinaryTreeLevelOrderTraversal102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    Map<Integer, List<Integer>> map = new HashMap<>(); //map level to list of node vals of that level
    int maxLevel = traverseTree(root, 0, map);
    List<List<Integer>> list = new LinkedList<>();
    for (int i = 0; i < maxLevel; i++) {
      list.add(map.get(i));
    }
    return list;
  }

  private int traverseTree(TreeNode root, int level, Map<Integer, List<Integer>> map) {
    if (root == null) {
      return level;
    }
    if (!map.containsKey(level)) { //if level is new, create list
      map.put(level, new LinkedList<>());
    }
    map.get(level).add(root.val); //add val to list of level
    return Math.max(level, Math.max(traverseTree(root.left, level + 1, map), traverseTree(root.right, level + 1, map)));
  }

  /**
   * 这个思路就很奇特了
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int currLevelSize = q.size();
    int i = 0;
    while (q.size() != 0) {
      TreeNode node = q.remove();
      arr.add(node.val);
      if (node.left != null)
        q.add(node.left);
      if (node.right != null)
        q.add(node.right);
      i++;
      if (i == currLevelSize) {
        res.add(arr);
        currLevelSize = q.size();
        i = 0;
        arr = new ArrayList<>();
      }
    }
    return res;
  }
}
