package com.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromicSubstring5 {

  /**
   * 暴力解法
   *
   * @param s
   * @return
   */
  public String longestPalindromeBrute(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String left = checkPalindrome(i, i + 1, s);
      String right = checkPalindrome(i, i, s);
      String tmp = left.length() > right.length() ? left : right;
      result = result.length() > tmp.length() ? result : tmp;
    }
    return result;
  }

  private String checkPalindrome(int left, int right, String s) {
    while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }

  public String longestPalindrome(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
      for (int j = i + 1; j < s.length(); j++) {

        if (s.charAt(j) == s.charAt(i) && (dp[i + 1][j - 1] || j - i == 1)) {
            dp[i][j] = true;
        }

        if (dp[i][j] && j - i > end - start) {
          end = j;
          start = i;
        }
      }
    }
    return s.substring(start, end + 1);
  }

  @Test
  void test() {
    System.out.println(longestPalindrome("abbac"));
    // dp = {0,0,1,2}
  }
}
