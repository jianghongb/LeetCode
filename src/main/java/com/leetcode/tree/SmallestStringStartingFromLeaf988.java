package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 *
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 *
 *
 *
 * Example 1:
 * a
 * /   \
 * b     c
 * / \   / \
 * d  e  d  e
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 *
 * Example 2:
 * z
 * /   \
 * b     d
 * / \   / \
 * b  d  a  c
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 *
 * Example 3:
 *
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 *
 *
 *
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 8500.
 * Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf988 {

  String ans = "~";

  /**
   * In our depth first search, we will maintain sb (or A in Python), the contents of a path from the root to this node.
   *
   * When we reach a leaf, we will reverse this path to create a candidate answer. If it is better than our current answer, we'll update our answer.
   *
   * @param root
   * @return
   */
  public String smallestFromLeaf2(TreeNode root) {
    dfs(root, new StringBuilder());
    return ans;
  }

  public void dfs(TreeNode node, StringBuilder sb) {
    if (node == null)
      return;
    sb.append((char) ('a' + node.val));

    if (node.left == null && node.right == null) {
      sb.reverse();
      String S = sb.toString();
      sb.reverse();

      if (S.compareTo(ans) < 0)
        ans = S;
    }

    dfs(node.left, sb);
    dfs(node.right, sb);
    sb.deleteCharAt(sb.length() - 1);
  }
}
