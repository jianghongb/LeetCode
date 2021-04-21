package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 *
 * 解题思路入下链接
 *
 * https://mp.weixin.qq.com/s/2WetyP6IYQ6VotegepVpEw
 */
public class PalindromicSubstrings647 {

  /**
   * 先求出子串 然后判断每个子串是不是回文, 这个是暴力解法
   *
   * @param s
   * @return
   */
  public int countSubstrings1(String s) {

    if (null == s) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String tmp = s.substring(i, j);
        if (isPalindromic(tmp)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isPalindromic(String s) {
    if (null == s || s.length() == 0) {
      return false;
    }
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public int countSubstrings(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int count = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i <= 1) {
            count++;
            dp[i][j] = true;
          } else if (dp[i + 1][j - 1]) {
            count++;
            dp[i][j] = true;
          }
        }
      }
    }
    return count;
  }

  int result;

  public int countSubstrings3(String s) {
    result = 0;
    for (int i = 0; i < s.length(); i++) {
      checkPalindrome(i, i + 1, s);
      checkPalindrome(i, i, s);
    }
    return result;
  }

  private void checkPalindrome(int left, int right, String s) {
    while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      result++;
      left--;
      right++;
    }
  }

  @Test
  void test() {
    System.out.println(countSubstrings3("aba"));
  }
}
