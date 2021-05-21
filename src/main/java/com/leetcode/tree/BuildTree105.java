package com.leetcode.tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BuildTree105 {

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(n)，其中 nnn 是树中的节点个数。
   *
   *     空间复杂度：O(n)，除去返回的答案需要的 O(n)空间之外，我们还需要使用 O(n) 的空间存储哈希映射，
   *     以及 O(h)（其中 h是树的高度）的空间表示递归时栈空间.这里 h<n ，所以总空间复杂度为 O(n)。
   *
   * @param preorder
   * @param inorder
   * @return
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (null == preorder || preorder.length == 0 || inorder == null || inorder.length == 0
        || inorder.length != preorder.length) {
      return null;

    }
    if (preorder.length == 1 && preorder.length == inorder.length) {
      return new TreeNode(preorder[0]);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTree(preorder, map, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int preIndex, int preEnd, int[] inorder,
      int inIndex, int inEnd) {
    if (preEnd < preIndex) {
      return null;
    }
    if (inEnd < inIndex) {
      return null;
    }

    int root = preIndex;
    int inorderRoot = map.get(preorder[root]);

    int size_inorder_subtree = inorderRoot - inIndex;

    TreeNode node = new TreeNode(preorder[root]);
    node.left = buildTree(preorder, map, preIndex + 1, preIndex + size_inorder_subtree, inorder, inIndex,
        inorderRoot - 1);
    node.right = buildTree(preorder, map, preIndex + size_inorder_subtree + 1, preEnd, inorder, inorderRoot + 1, inEnd);
    return node;
  }

  /**
   * 时间复杂度：O(n)，其中 n是树中的节点个数。
   *
   * 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(h)（其中 h 是树的高度）的空间存储栈
   * 这里 h<n，所以（在最坏情况下）总空间复杂度为 O(n)
   *
   * @param preorder
   * @param inorder
   * @return
   */
  public TreeNode buildTree2(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    int inorderIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
      } else {
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex++;
        }
        node.right = new TreeNode(preorderVal);
        stack.push(node.right);
      }
    }
    return root;
  }


}
