package com.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class LongestPalindromicSubsequence {

  public int longestPalindromeSubseq(String s) {
    int len = 0;
    int[][] dp = new int[s.length()][s.length()];

    for (int g = 0; g < s.length(); g++) {

      for (int i = 0, j = g; j < s.length(); i++, j++) {

        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2;
          } else {
            dp[i][j] = 1;
          }
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
          }
        }
      }
    }
    return dp[0][s.length() - 1];
  }

  public int longestPalindromeSubseq2(String s) {
    int[][] dp = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i + 1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][s.length() - 1];
  }

  public int longestPalindromeSubseq3(String s) {
    int n = s.length();
    int[] dp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = 1;
      int pre = 0;
      for (int j = i + 1; j < n; j++) {
        int temp = dp[j];
        if (s.charAt(i) == s.charAt(j)) {
          dp[j] = pre + 2;
        } else {
          dp[j] = Math.max(temp, dp[j - 1]);
        }
        pre = temp;
      }
    }
    return dp[n - 1];
  }

  @Test
  void test(){
    System.out.println(longestPalindromeSubseq2("cbbd"));

  }
}

