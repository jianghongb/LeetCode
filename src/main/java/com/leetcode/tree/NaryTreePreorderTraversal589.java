package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 *
 * Example 2:
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
public class NaryTreePreorderTraversal589 {

  /**
   * 通过递归实现
   */
  List<Integer> preOrder = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    preOrder.add(root.val);
    for (Node node : root.children) {
      preorder(node);
    }
    return preOrder;
  }

  /**
   * 通过stack实现
   *
   * @param root
   * @return
   */
  public List<Integer> preorder2(Node root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<Node> s = new Stack<>();
    s.push(root);
    while (!s.isEmpty()) {
      Node pop = s.pop();
      result.add(pop.val);
      if (pop.children == null) {
        continue;
      }
      for (int i = pop.children.size() - 1; i >= 0; i--) {
        s.push(pop.children.get(i));
      }
    }
    return result;
  }
}
