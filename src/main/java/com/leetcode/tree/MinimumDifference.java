package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference
 * between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 * the same as 783 https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumDifference {

  Integer prev;
  int minDiff = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (prev != null) {
      minDiff = Math.min(minDiff, Math.abs(root.val - prev));
    }
    prev = root.val;
    inorder(root.right);
  }

  /**
   *  中序遍历整个BST 树，得到一个有序数组，然后找到数组中最小的任意两数字之差
   * @param root
   * @return
   */
  public int getMinimumDifference2(TreeNode root) {
    // BST - inorder traversal representation
    List<Integer> list = new ArrayList<>();
    inOrderTraversal(root, list);
    int min = Integer.MAX_VALUE;
    int length = list.size();
    int a = 0, b = 0;
    for(int i = 0; i < length - 1; i++){
      a = list.get(i);
      b = list.get(i+1);
      min = Math.min(min, Math.abs(a-b));
    }
    return min;
  }

  private void inOrderTraversal(TreeNode root, List<Integer> list){
    if(root == null) return;
    inOrderTraversal(root.left, list);
    list.add(root.val);
    inOrderTraversal(root.right, list);
  }
}
