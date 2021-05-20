package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 * 0
 * /  \
 * -3   9
 * /     /
 * -10   5
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArraytoBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }
    if (l == r) {
      return new TreeNode(nums[l]);
    }
    int mid = (l + r) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, l, mid - 1);
    root.right = helper(nums, mid + 1, r);
    return root;
  }

  @Test
  void test() {
    int[] nums = { -10, -3, 0, 5, 9 };
    TreeNode root = sortedArrayToBSTLiner(nums);
    printLevel(root);
  }

  private void printLevel(TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        if (curr.left != null) {
          queue.offer(curr.left);
        }
        if (curr.right != null) {
          queue.offer(curr.right);
        }
        System.out.print(curr.val + ", ");
      }
      System.out.println();
    }

  }

  public TreeNode sortedArrayToBSTLiner(int[] nums) {
    TreeNode node = null;
    if (nums == null || nums.length == 0) {
      return node;
    }

    Queue<TreeNode> nodes = new LinkedList<>();

    int middle, from, to;

    middle = (nums.length - 1) / 2;
    node = new TreeNode(nums[middle]);
    nodes.add(node);

    Queue<Integer> indexes = new LinkedList<>();
    indexes.add(0);
    indexes.add(middle - 1);
    indexes.add(middle + 1);
    indexes.add(nums.length - 1);

    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = nodes.poll();

        for (int k = 0; k < 2; k++) {
          from = indexes.poll();
          to = indexes.poll();

          if (from <= to) {
            middle = (from + to) / 2;

            if (k == 0) {
              current.left = new TreeNode(nums[middle]);
              nodes.add(current.left);
            } else {
              current.right = new TreeNode(nums[middle]);
              nodes.add(current.right);
            }

            indexes.add(from);
            indexes.add(middle - 1);
            indexes.add(middle + 1);
            indexes.add(to);
          }
        }
      }
    }

    return node;
  }
}
