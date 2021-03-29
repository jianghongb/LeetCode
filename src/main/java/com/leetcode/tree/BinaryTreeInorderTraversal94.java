package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeInorderTraversal94 {

  List<Integer> result = new ArrayList<>();

  /**
   * 递归的方式实现
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal1(TreeNode root) {

    if (root == null) {
      return result;
    }
    inorderTraversal1(root.left);
    result.add(root.val);
    inorderTraversal1(root.right);
    return result;
  }

  /**
   * 通过栈来实现
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode left = root;
    while (left != null || !stack.isEmpty()) {
      while (left != null) { //go as left as possible
        stack.push(left);
        left = left.left;
      }
      TreeNode le = stack.pop(); // add the first leftmost element and then look for same in right
      result.add(le.val);
      left = le.right;
    }
    return result;
  }

  /**
   * Step 1: Initialize current as root
   *
   * Step 2: While current is not NULL,
   *
   * If current does not have left child
   *
   * a. Add current’s value
   *
   * b. Go to the right, i.e., current = current.right
   *
   * Else
   *
   * a. In current's left subtree, make current the right child of the rightmost node
   *
   * b. Go to this left child, i.e., current = current.left
   *
   * e.g.
   *
   *     1
   *   /   \
   *  2     3   --->
   * / \   /
   *4  5  6
   * First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is
   *    2
   *   / \
   *  4   5
   * So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = cuurent.left (current = 2). The tree now looks like:
   *          2
   *         / \
   *        4   5
   *             \
   *              1
   *               \
   *                3
   *               /
   *              6
   * For current 2, which has left child 4, we can continue with thesame process as we did above
   *         4
   *          \
   *           2
   *            \
   *             5
   *              \
   *               1
   *                \
   *                 3
   *                /
   *               6
   *
   * then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above. Finally, the inorder taversal is [4,2,5,1,6,3].
   * Complexity Analysis
   *
   * Time complexity : O(n)O(n)O(n). To prove that the time complexity is O(n)O(n)O(n), the biggest problem lies in finding the time complexity of finding the predecessor nodes of all the nodes in the binary tree. Intuitively, the complexity is O(nlog⁡n)O(n\log n)O(nlogn), because to find the predecessor node for a single node related to the height of the tree. But in fact, finding the predecessor nodes for all nodes only needs O(n)O(n)O(n) time. Because a binary Tree with nnn nodes has n−1n-1n−1 edges, the whole processing for each edges up to 2 times, one is to locate a node, and the other is to find the predecessor node. So the complexity is O(n)O(n)O(n).
   *
   * Space complexity : O(n)O(n)O(n). Arraylist of size nnn is used.
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right; // move to next right node
      } else { // has a left subtree
        pre = curr.left;
        while (pre.right != null) { // find rightmost
          pre = pre.right;
        }
        pre.right = curr; // put cur after the pre node
        /**
         * make current node left tree null
         */
        TreeNode temp = curr; // store cur node
        curr = curr.left; // move cur to the top of the new tree
        temp.left = null; // original cur left be null, avoid infinite loops
      }
    }
    return res;
  }
}
