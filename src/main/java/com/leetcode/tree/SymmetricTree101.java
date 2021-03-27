package com.leetcode.tree;

import javax.xml.soap.Node;
import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */
public class SymmetricTree101 {

  /**
   * 这是我的方案 但是不能解决： put [1,2,2,2,null,2]， 因为左右子树值相等 但是其实并不是对称的情况
   *
   * @param root
   * @return
   */
  public static boolean isSymmetricBad(TreeNode root) {
    if (root == null) {
      return true;
    }
    preOrder(root);
    int left = 0;
    int right = orders.size() - 1;
    while (left < right) {
      if (orders.get(left) == orders.get(right)) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }

  static List<Integer> orders = new ArrayList<>();

  static void preOrder(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    if (treeNode.left != null) {
      preOrder(treeNode.left);

    }
    orders.add(treeNode.val);
    if (treeNode.right != null) {
      preOrder(treeNode.right);
    }
  }

  static TreeNode buildTree() {
    int[] a = { 1, 2, 2, 0, 3, 0, 3 };
    TreeNode root = new TreeNode(a[0]);
    TreeNode left = new TreeNode(a[1]);
    TreeNode right = new TreeNode(a[2]);
    TreeNode leftleft = new TreeNode(a[3]);
    TreeNode leftright = new TreeNode(a[4]);
    TreeNode rightleft = new TreeNode(a[5]);
    TreeNode rightright = new TreeNode(a[6]);

    right.left = null;
    right.right = rightright;
    left.left = null;
    left.right = leftright;
    root.left = left;
    root.right = right;
    //    int length = a.length;
    //    int i = 1;
    //    while (i < length) {
    //      if (i % 2 == 1) {
    //        root.left = new TreeNode(a[i]);
    //      } else {
    //        root.right = new TreeNode(a[i]);
    //      }
    //    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode node = buildTree();
    System.out.println(isSymmetric(node));
  }

  public static boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return check(root.left, root.right);
  }

  public static boolean check(TreeNode p1, TreeNode p2) {
    if (p1 == null && p2 == null)
      return true;
    if (p1 == null || p2 == null)
      return false;
    if (p1.val != p2.val)
      return false;
    return check(p1.left, p2.right) && check(p1.right, p2.left);
  }

}
