package com.leetcode.string;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 *
 *
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString344 {

  /**
   * 遍历 交换
   * @param s
   */
  public void reverseString(char[] s) {
    int length = s.length;
    for (int i = 0; i < s.length / 2; i++) {
      char tmp = s[i];
      s[i] = s[length - 1 - i];
      s[length - 1 - i] = tmp;
    }
  }

  /**
   * 头尾各一个计数器 只要不交叉便交换
   *
   * @param s
   */
  public void reverseString2(char[] s) {
    int start = 0;
    int end = s.length - 1;

    while(start < end){
      char temp = s[start];
      s[start] = s[end];
      s[end] = temp;
      start++;
      end--;
    }
  }
}
