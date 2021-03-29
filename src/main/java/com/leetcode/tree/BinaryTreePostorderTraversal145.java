package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * Output: [2,1]
 *
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal145 {

  List<Integer> result = new ArrayList<>();

  public List<Integer> postorderTraversal1(TreeNode root) {
    if (root == null) {
      return result;
    }
    if (root.left != null) {
      postorderTraversal1(root.left);
    }
    if (root.right != null) {
      postorderTraversal1(root.right);
    }
    result.add(root.val);
    return result;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    // We will have a pointer to the recently popped node
    TreeNode curr = root, prev = null;

    while (curr != null || !stack.isEmpty()) {
      // Keep on iterating towards the leftmost node
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      // If there is no right child
      // or right child is the one that we recently visited
      // it means we have traversed all the nodes of stack.peek()
      if (stack.peek().right == null || stack.peek().right == prev) {
        // we will update the prev node
        prev = stack.pop();
        result.add(prev.val);
      } else {
        // Otherwise we will visit the right child.
        curr = stack.peek().right;
      }
    }

    return result;
  }

  public List<Integer> postorderTraversal3(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    stack.push(node);
    while (!stack.isEmpty()) {
      node = stack.pop();
      result.add(0, node.val);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return result;
  }

  // iterative
  public List<Integer> postorderTraversal4(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null)
      return result;

    Stack<TreeNode> s = new Stack<>();
    Stack<TreeNode> out = new Stack<>();

    s.push(root);

    while (!s.isEmpty()) {
      TreeNode currNode = s.pop();
      if (currNode != null)
        out.push(currNode);
      if (currNode.left != null)
        s.push(currNode.left);
      if (currNode.right != null)
        s.push(currNode.right);
    }

    while (!out.isEmpty()) {
      TreeNode outNode = out.pop();
      result.add(outNode.val);
    }

    return result;
  }
}
