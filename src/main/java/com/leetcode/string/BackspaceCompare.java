package com.leetcode.string;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 *
 * Input: s = "a##c", t = "#a#c"
 * Output: true
 * Explanation: Both s and t become "c".
 *
 * Example 4:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */
public class BackspaceCompare {
  /**
   * time: O(M+N)
   * space:O(M+N)
   */
  public boolean backspaceCompare(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    String s1 = backspace(s);
    String t1 = backspace(t);
    return s1.equals(t1);
  }

  private String backspace(String s) {
    StringBuilder builder = new StringBuilder();
    int index = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '#') {

        if (index > 0) {
          builder.deleteCharAt(--index);
        }
      } else {
        builder.append(s.charAt(i));
        index++;
      }
    }
    return builder.toString();
  }

  public boolean backspaceCompare2(String S, String T) {
    return build(S).equals(build(T));
  }

  public String build(String S) {
    Stack<Character> ans = new Stack();
    for (char c : S.toCharArray()) {
      if (c != '#')
        ans.push(c);
      else if (!ans.empty())
        ans.pop();
    }
    return String.valueOf(ans);
  }

  /**
   * time: O(M+N)
   * space:O(1)
   */
  public boolean backspaceCompare3(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
      while (i >= 0) { // Find position of next possible char in build(S)
        if (S.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }
      while (j >= 0) { // Find position of next possible char in build(T)
        if (T.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else {
          break;
        }
      }
      // If two actual characters are different
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
        return false;
      }
      // If expecting to compare char vs nothing
      if ((i >= 0) != (j >= 0)) {
        return false;
      }
      i--;
      j--;
    }
    return true;
  }

  @Test
  void test() {
    String s = "a#c", t = "b";

    System.out.println(backspaceCompare3(s, t));
  }
}
