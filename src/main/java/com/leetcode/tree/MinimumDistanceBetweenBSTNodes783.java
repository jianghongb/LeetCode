package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 *
 * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 */
public class MinimumDistanceBetweenBSTNodes783 {

  /**
   * @param root
   * @return
   */
  public int minDiffInBST(TreeNode root) {

    if (root == null) {
      return 0;
    }
    Stack<TreeNode> s = new Stack<>();
    s.push(root);
    int value = 0;
    int min = root.val;
    while (!s.isEmpty()) {
      TreeNode pop = s.pop();
      if(value == 0){
        value = root.val;
      }
      if (pop.left != null) {
        s.push(pop.left);
        int tmp = Math.abs(value - pop.left.val);
        min = Math.min(tmp, min);
      }
      if (pop.right != null) {
        s.push(pop.right);
        int tmp = Math.abs(pop.right.val - value);
        min = Math.min(min, tmp);
      }
    }
    return min;
  }
  Integer prev;
  int minDiff = Integer.MAX_VALUE;

  /**
   * O(n) time
   * @param root
   * @return
   */
  public int minDiffInBST2(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  private void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    if (prev != null)
      minDiff = Math.min(minDiff, Math.abs(root.val - prev));
    prev = root.val;
    inorder(root.right);
  }
  /**
   *
   Method 2: O(n) time and space
   */

  public int minDiffInBST3(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    minDiffInBST(root, list);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < list.size(); i++)
      min = Math.min(min, list.get(i).val - list.get(i-1).val);
    return min;
  }

  private void minDiffInBST(TreeNode root, List<TreeNode> list) {
    if (root == null)
      return;
    minDiffInBST(root.left, list);
    list.add(root);
    minDiffInBST(root.right, list);
  }

}
