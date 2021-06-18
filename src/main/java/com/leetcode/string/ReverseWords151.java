package com.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 *
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 */
public class ReverseWords151 {

  public String reverseWords(String s) {

    if (s == null || s.length() == 0) {
      return s;
    }

    int fromIndex = 0;
    while (fromIndex < s.length()) {
      if (s.charAt(fromIndex) != ' ') {
        break;
      } else {
        fromIndex++;
      }
    }

    int end = s.length() - 1;
    while (end > fromIndex) {
      if (s.charAt(end) == ' ') {
        end--;
      } else {
        break;
      }
    }
    StringBuilder sb = new StringBuilder();
    while (fromIndex <= end) {
      char tmp = s.charAt(end);
      if (tmp != ' ' || sb.charAt(sb.length() - 1) != ' ') {
        sb.append(tmp);
      }
      end--;
    }

    int start = 0;
    end = 1;
    while (start < sb.length()) {
      while (end < sb.length() && sb.charAt(end) != ' ') {
        end++;
      }
      reverse(sb, start, end - 1);
      start = end + 1;
      end = start + 1;
    }
    return sb.toString();
  }

  private void reverse(StringBuilder sb, int start, int end) {
    while (start < end) {
      char tmp = sb.charAt(start);
      sb.setCharAt(start, sb.charAt(end));
      sb.setCharAt(end, tmp);
      start++;
      end--;
    }
  }

  @Test
  void test() {
    String s = "  the sky is blue  ";
    System.out.println(reverseWords(s));
  }
}
