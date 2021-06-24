package com.leetcode.string;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ShortestPalindrome241 {

  /**
   * 前缀不减一
   *
   * @param str
   * @return
   */
  public int KMP(StringBuilder str) {
    int[] LPS = new int[str.length()];
    int i = 1;
    int len = 0;
    while (i < str.length()) {
      if (str.charAt(i) == str.charAt(len)) {
        len++;
        LPS[i++] = len;
      } else {
        if (len > 0) {
          len = LPS[len - 1]; // really tricky
          // point to note is we are not incrementing i here
        } else {
          LPS[i++] = 0;
        }
      }
    }
    for (int i1 = 0; i1 < LPS.length; i1++) {
      System.out.print(LPS[i1] + ",");
    }
    System.out.println(Arrays.stream(LPS).toArray());
    return LPS[str.length() - 1];
  }

  public String shortestPalindrome(String s) {
    StringBuilder part1 = new StringBuilder(s);
    StringBuilder part2 = new StringBuilder(s).reverse();
    StringBuilder str = part1.append("#").append(part2);
    int len = kmp(str.toString()) + 1;

    System.out.println(len);
    StringBuilder ans = new StringBuilder(s.substring(len)).reverse();
    System.out.println(ans);

    return ans.toString() + s;
  }

  /**
   * kmp 前缀统一减一
   *
   * @param s
   * @return
   */
  private int kmp(String s) {
    int[] next = new int[s.length()];
    int j = -1;
    next[0] = j;

    for (int i = 1; i < s.length(); i++) {
      while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
        j = next[j];
      }
      if (s.charAt(i) == s.charAt(j + 1)) {
        j++;
      }
      next[i] = j;
    }
    for (int i1 = 0; i1 < next.length; i1++) {
      System.out.print(s.charAt(i1) + " ,");
    }
    System.out.println();
    for (int i1 = 0; i1 < next.length; i1++) {
      System.out.print(next[i1] + ",");
    }
    return next[s.length() - 1];
  }

  @Test
  void test() {
    String haystack = "aacecaaa";
    System.out.println(shortestPalindrome(haystack));
  }
}
