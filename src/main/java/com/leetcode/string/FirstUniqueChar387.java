package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 */
public class FirstUniqueChar387 {

  /**
   * 思路： 把String转成map<String,Integer>
   *
   * @param s
   * @return
   */
  public static int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    if (s.length() == 1) {
      return 0;
    }
    Map<String, Integer> result = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Integer integer = result.get(s.charAt(i) + "");
      if (integer == null) {
        result.put(s.charAt(i) + "", 1);
      } else {
        result.put(s.charAt(i) + "", integer + 1);
      }
    }

    int min = Integer.MAX_VALUE;
    for (Map.Entry entry : result.entrySet()) {
      if (entry.getValue().equals(Integer.valueOf(1))) {
        int index = s.indexOf(entry.getKey() + "");
        if (index < min) {
          min = index;
        }
      }
    }
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }

  /**
   * 遍历字符串，如果 index == lastIndex, 则只出现一次， 那么比较哪个字符index比较小就可以了
   *
   * @param s
   * @return index of first unique char
   */
  public static int firstUniqChar2(String s) {

    if (s == null || s.length() == 0)
      return -1;

    int result = s.length();

    for (char c = 'a'; c <= 'z'; ++c) {
      int firstIdx = s.indexOf(c);
      if (firstIdx != -1 && firstIdx == s.lastIndexOf(c))
        result = Math.min(result, firstIdx);
    }

    return result == s.length() ? -1 : result;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar2("loveleetcode"));
  }
}
