package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import sun.reflect.generics.tree.Tree;

/**
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *
 *
 * Example 1:
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class KthSmallestElementBST {

  public int kthSmallest(TreeNode root, int k) {
    if (root == null || k < 0) {
      return -1;
    }
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    return list.get(k - 1);
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  public int kthSmallest2(TreeNode root, int k) {
    if (root == null || k < 0) {
      return -1;
    }
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) {
        return root.val;
      }
      root = root.right;
    }
  }

}
