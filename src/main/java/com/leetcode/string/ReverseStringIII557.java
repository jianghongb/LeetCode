package com.leetcode.string;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseStringIII557 {

  /**
   * 思路： 把String 按照“” 分成不同的数组，然后每个反转之后 再重新拼接
   *
   * @param s
   * @return
   */
  public static String reverseWords2(String s) {
    if (s == null || s.length() == 1) {
      return s;
    }

    String result = "";
    List<String> list = Arrays.asList(s.split(" "));
    for (String item : list) {
      char[] itemArray = item.toCharArray();
      int i = 0;
      int j = item.length() - 1;
      while (i < j) {
        char tmp = itemArray[i];
        itemArray[i] = itemArray[j];
        itemArray[j] = tmp;
        i++;
        j--;
      }
      result += String.valueOf(itemArray);
      result += " ";
    }
    return result.substring(0, result.length() - 1);
  }

  public static String reverseWords3(String s) {
    String result = "";
    while (s.indexOf(' ') != -1 && s.indexOf(' ') < s.length()) {
      int i = s.indexOf(' ');
      char[] itemArray = s.substring(0, i).toCharArray();
      int begin = 0;
      int end = i - 1;
      swap(begin, end, itemArray);
      s = s.substring(i + 1);
      result += String.valueOf(itemArray);
      result += " ";
    }
    if (s != null) {
      int begin = 0;
      int end = s.length() - 1;
      char[] chars = s.toCharArray();
      swap(begin, end, chars);
      result += String.valueOf(chars);
    }
    return result;
  }

  private static void swap(int begin, int end, char[] array) {
    while (begin < end) {
      char tmp = array[begin];
      array[begin] = array[end];
      array[end] = tmp;
      begin++;
      end--;
    }
  }

  /**
   * 递归操作
   *
   * @param s
   * @return
   */
  public String reverseWords(String s) {
    char[] charArray = s.toCharArray();
    reverse(charArray, 0);
    return String.valueOf(charArray);
  }

  private void reverse(char[] arr, int index) {
    int left = index;
    while (index < arr.length && arr[index] != ' ') {
      index++;
    }
    int right = index - 1;

    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    if (index < arr.length - 1) {
      reverse(arr, index + 1);
    }
  }
}
