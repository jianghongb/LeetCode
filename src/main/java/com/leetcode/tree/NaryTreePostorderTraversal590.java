package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
public class NaryTreePostorderTraversal590 {

  /**
   * 通过HashMap和Stack联合
   *
   * @param root
   * @return
   */
  public List<Integer> postorder(Node root) {
    HashMap<Node, Boolean> map = new HashMap<>();
    List<Integer> post = new ArrayList<>();
    if (root == null)
      return post;
    Stack<Node> st = new Stack<>();
    st.push(root);
    while (!st.isEmpty()) {
      Node par = st.peek();
      if (par.children.size() == 0) {
        st.pop();
        post.add(par.val);
      } else if (!map.containsKey(par) || !map.get(par)) {
        map.put(par, true);
        for (int i = par.children.size() - 1; i >= 0; i--)
          st.push(par.children.get(i));
      } else {
        st.pop();
        post.add(par.val);
      }
    }
    return post;

  }

  /**
   * 利用LinkedLi addFirst 实现
   * 或者利用preorder方案 再反转结果实现
   *
   * @param root
   * @return
   */
  public List<Integer> postorder2(Node root) {
    LinkedList<Integer> result = new LinkedList<>();
    if (root == null) {
      return result;
    }

    Stack<Node> s = new Stack<>();
    s.push(root);
    while (!s.isEmpty()) {
      Node pop = s.pop();
      result.addFirst(pop.val);
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
