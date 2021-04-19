package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {

  @Test
  void test() {
    String s = "aab";
    List<List<String>> partition = partition(s);
    partition.stream().forEach(
        System.out::println
    );
  }

  /**
   * 每一个结点表示剩余没有扫描到的字符串，产生分支是截取了剩余字符串的前缀；
   * 产生前缀字符串的时候，判断前缀字符串是否是回文。
   *
   *     如果前缀字符串是回文，则可以产生分支和结点；
   *     如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作。
   *
   * 在叶子结点是空字符串的时候结算，此时 从根结点到叶子结点的路径，就是结果集里的一个结果，使用深度优先遍历，记录下所有可能的结果。
   * 使用一个路径变量 path 搜索，path 全局使用一个（注意结算的时候，要生成一个拷贝），因此在递归执行方法结束以后需要回溯，即将递归之前添加进来的元素拿出去；
   * path 的操作只在列表的末端，因此合适的数据结构是栈。
   *
   * @param s
   * @return
   */
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    dfs(0, result, new ArrayList<>(), s);
    return result;
  }

  void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
    if (start >= s.length()) {
      result.add(new ArrayList<>(currentList));
    }
    for (int end = start; end < s.length(); end++) {
      if (isPalindrome(s, start, end)) {
        // add current substring in the currentList
        currentList.add(s.substring(start, end + 1));
        dfs(end + 1, result, currentList, s);
        // backtrack and remove the current substring from currentList
        currentList.remove(currentList.size() - 1);
      }
    }
  }

  boolean isPalindrome(String s, int low, int high) {
    while (low < high) {
      if (s.charAt(low++) != s.charAt(high--)) {
        return false;
      }
    }
    return true;
  }

  public List<List<String>> partition2(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    List<List<String>> result = new ArrayList<>();
    dfs(result, s, 0, new ArrayList<>(), dp);
    return result;
  }

  void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
    if (start >= s.length()) {
      result.add(new ArrayList<>(currentList));
    }
    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
        dp[start][end] = true;
        currentList.add(s.substring(start, end + 1));
        dfs(result, s, end + 1, currentList, dp);
        currentList.remove(currentList.size() - 1);
      }
    }
  }
}
