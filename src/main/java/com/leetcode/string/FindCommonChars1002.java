package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given an array words of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 *
 * Note:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
public class FindCommonChars1002 {

  public List<String> commonChars2(String[] words) {
    List<String> res = new ArrayList<>();
    if (words == null || words.length == 0) {
      return res;
    }
    int length = words.length;
    int[] commons = new int[26];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        commons[words[i].charAt(j) - 'a']++;
      }
    }
    for (int i = 0; i < commons.length; i++) {
      while (commons[i] / length > 0) {
        char c = (char) (i + 'a');
        res.add(String.valueOf(c));
        commons[i] = commons[i] - length;
      }
    }
    return res;
  }

  public List<String> commonChars(String[] A) {
    List<String> result = new ArrayList<>();
    if (A.length == 0)
      return result;
    int[] hash = new int[26]; // 用来统计所有字符串里字符出现的最小频率
    for (int i = 0; i < A[0].length(); i++) { // 用第一个字符串给hash初始化
      hash[A[0].charAt(i) - 'a']++;
    }
    // 统计除第一个字符串外字符的出现频率
    for (int i = 1; i < A.length; i++) {
      int[] hashOtherStr = new int[26];
      for (int j = 0; j < A[i].length(); j++) {
        hashOtherStr[A[i].charAt(j) - 'a']++;
      }
      // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
      for (int k = 0; k < 26; k++) {
        hash[k] = Math.min(hash[k], hashOtherStr[k]);
      }
    }
    // 将hash统计的字符次数，转成输出形式
    for (int i = 0; i < 26; i++) {
      while (hash[i] != 0) { // 注意这里是while，多个重复的字符
        char c = (char) (i + 'a');
        result.add(String.valueOf(c));
        hash[i]--;
      }
    }
    return result;
  }

  @Test
  void test() {

    String[] words = { "cool","lock","cook"/*"lol", "ciik"*/ };
    //  commonChars(words)

    System.out.println(commonChars(words));
  }
}
