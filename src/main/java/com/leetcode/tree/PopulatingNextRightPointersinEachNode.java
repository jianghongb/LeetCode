package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * 1
 * /  \
 * 2    3
 * / \   / \
 * 4  5  6  7
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 */
public class PopulatingNextRightPointersinEachNode {

  /**
   * 层序遍历的思想
   *
   * @param root
   * @return
   */
  public Node1 connect(Node1 root) {
    if (root == null) {
      return root;
    }

    Queue<Node1> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node1 poll = queue.poll();
        if (i != size - 1) {
          poll.next = queue.peek();
        }

        if (poll.left != null) {
          queue.offer(poll.left);
        }
        if (poll.right != null) {
          queue.offer(poll.right);
        }
      }
    }
    return root;
  }

  public Node1 connect1(Node1 root) {
    if (root == null)
      return root;
    Queue<Node1> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node1 node = q.poll();
        if (i != size - 1) {
          node.next = q.peek();
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
    }

    return root;
  }

  /**
   * 尝试用递归解决
   *
   * @param root
   * @return
   */
  public Node1 connect2(Node1 root) {
    if (root == null) {
      return root;
    }
    nextRight(root);
    return root;
  }
  private void nextRight(Node1 root){
    if(root.left == null && root.right == null){
      return;
    }
    root.left.next = root.right;
    if(root.next !=null ){
      root.right.next = root.next.left; // 右孩子的下一个等于兄弟的左孩子
    }
    nextRight(root.left);
    nextRight(root.right);
  }
}

class Node1 {

  public int val;
  public Node1 left;
  public Node1 right;
  public Node1 next;

  public Node1() {
  }

  public Node1(int _val) {
    val = _val;
  }

  public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
