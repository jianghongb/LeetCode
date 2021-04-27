package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 *
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * 我们来讲一讲如何使用动态规划，来解决这道题目。
 *
 * 关于回文子串，两道题目题目大家是一定要掌握的。
 *
 * 动态规划：647. 回文子串
 * 5.最长回文子串 和 647.回文子串基本一样的
 * 这两道题目是回文子串的基础题目，本题也要用到相关的知识点。
 *
 * 动规五部曲分析如下：
 *
 * 确定dp数组（dp table）以及下标的含义
 * dp[i]：范围是[0, i]的回文子串，最少分割次数是dp[i]。
 *
 * 确定递推公式
 * 来看一下由什么可以推出dp[i]。
 *
 * 如果要对长度为[0, i]的子串进行分割，分割点为j。
 *
 * 那么如果分割后，区间[j + 1, i]是回文子串，那么dp[i] 就等于 dp[j] + 1。
 *
 * 这里可能有同学就不明白了，为什么只看[j + 1, i]区间，不看[0, j]区间是不是回文子串呢？
 *
 * 那么在回顾一下dp[i]的定义：范围是[0, i]的回文子串，最少分割次数是dp[i]。
 *
 * [0, j]区间的最小切割数量，我们已经知道了就是dp[j]。
 *
 * 此时就找到了递推关系，当切割点j在[0, i] 之间时候，dp[i] = dp[j] + 1;
 *
 * 本题是要找到最少分割次数，所以遍历j的时候要取最小的dp[i]。
 *
 * 所以最后递推公式为：dp[i] = min(dp[i], dp[j] + 1);
 *
 * 注意这里不是要 dp[j] + 1 和 dp[i]去比较，而是要在遍历j的过程中取最小的dp[i]！
 *
 * 可以有dp[j] + 1推出，当[j + 1, i] 为回文子串
 */
public class PalindromicSubstrings {

  public int minCut(String s) {
    boolean[][] isPalindromic = new boolean[s.length()][s.length()];
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalindromic[i + 1][j - 1])) {
          isPalindromic[i][j] = true;
        }
      }
    }
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i] = i;
    }

    for (int i = 0; i < s.length(); i++) {
      if (isPalindromic[0][i]) {
        dp[i] = 0;
        continue;
      }
      for (int j = 0; j < i; j++) {
        if (isPalindromic[j + 1][i]) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }

    return dp[s.length() - 1];

  }

  @Test
  void test() {
    System.out.println(minCut("aabc"));
  }
}
