package com.leetcode.string;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */
public class ReverseStringII541 {

  /**
   * https://mp.weixin.qq.com/s/pzXt6PQ029y7bJ9YZB2mVQ
   *
   * @param s
   * @param k
   * @return
   */
  public String reverseStr4(String s, int k) {
    StringBuilder res = new StringBuilder();
    int start = 0, end = s.length();

    while (start < end) {

      StringBuilder tmp = new StringBuilder();

      int firstK = (start + k) < s.length() ? start + k : s.length();
      int secondK = (start + 2 * k) < s.length() ? start + 2 * k : s.length();

      tmp.append(s, start, firstK);
      res.append(tmp.reverse());

      if (firstK < secondK) {
        res.append(s, firstK, secondK);
      }
      start += 2 * k;
    }
    return res.toString();
  }

  public static String reverseStr(String s, int k) {
    if (k == 1)
      return s;
    else {
      int length = s.length();
      char[] tempChar = s.toCharArray();
      char temp;
      int i = 0;
      while (i < length - 1) {
        int startIndex = i;
        int endIndex = (k + i - 1) >= length ? length - 1 : k + i - 1;
        i = i + (2 * k);
        while (startIndex < endIndex) {
          temp = tempChar[startIndex];
          tempChar[startIndex++] = tempChar[endIndex];
          tempChar[endIndex--] = temp;
        }
      }
      return String.valueOf(tempChar);
    }
  }

  public String reverseStr2(String s, int k) {
    char[] ch = s.toCharArray();
    for (int i = 0; i < s.length(); i += 2 * k)
      reverse(ch, i, Math.min(i + k - 1, s.length() - 1));
    return new String(ch);
  }

  public void reverse(char[] ch, int left, int right) {
    while (left < right)
      swap(ch, left++, right--);
  }

  public void swap(char[] ch, int a, int b) {
    char temp = ch[a];
    ch[a] = ch[b];
    ch[b] = temp;
  }

  public static void main(String[] args) {
    String s = "abcdefg";
    String result = reverseStr(s, 2);
  }
}
