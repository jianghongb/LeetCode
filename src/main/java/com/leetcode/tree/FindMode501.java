package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
public class FindMode501 {

  Map<Integer, Integer> counts = new HashMap<>();
  int max = Integer.MIN_VALUE;

  public int[] findMode(TreeNode root) {
    searchTree(root);
    int i = 0;
    int[] result = new int[counts.keySet().size()];
    for (Integer key : counts.keySet()) {
      if (max == counts.get(key)) {
        result[i++] = key;
      }
    }
    return Arrays.copyOf(result, i);
  }

  private void searchTree(TreeNode node) {
    if (node == null) {
      return;
    }

    searchTree(node.left);
    int count = counts.getOrDefault(node.val, 0) + 1;
    if (count > max) {
      max = count;
    }
    counts.put(node.val, count);
    searchTree(node.right);
  }

  Integer pre;
  int count = 0;

  public int[] findMode2(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorder(root, ans);

    int[] res = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      res[i] = ans.get(i);
    }
    return res;
  }

  public void inorder(TreeNode root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    inorder(root.left, ans);

    if (pre == null || root.val != pre) {
      count = 1;
    } else if (pre == null || root.val == pre) {
      count++;
    }
    pre = root.val;
    if (count > max) {
      ans.clear();
      ans.add(pre);
      max = count;
    } else if (count == max) {
      ans.add(pre);
    }
    inorder(root.right, ans);
  }
}
