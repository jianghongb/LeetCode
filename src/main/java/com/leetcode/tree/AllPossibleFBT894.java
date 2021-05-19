package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AllPossibleFBT894 {

  public List<TreeNode> allPossibleFBT(int n) {
    List<TreeNode> ans = new ArrayList<>();
    if (n % 2 == 0) {
      return ans;
    }
    if (n == 1) {
      TreeNode root = new TreeNode(0);
      ans.add(root);
    }
    for (int i = 1; i < n; i += 2) {
      for (TreeNode left : allPossibleFBT(i)) {
        for (TreeNode right : allPossibleFBT(n - i - 1)) {
          TreeNode root = new TreeNode(0);
          root.left = left;
          root.right = right;
          ans.add(root);
        }
      }
    }
    return ans;
  }


  @Test
  void test(){
    allPossibleFBT(7).forEach( node->{
      preOrder(node);
      System.out.println();
    });


  }

  void preOrder(TreeNode node){
    if(node == null){
//      System.out.print("null, ");
      return;
    }
    System.out.print(node.val+", ");
    preOrder(node.left);
    preOrder(node.right);
  }
}
