package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class PartitionLabels {

  /**
   * 思路：
   *   遍历字符串。
   *   一个值记录遍历到的这些字符串所遇到的最后的位置。
   *   如果这个值就是当前位置就说明可以切割了，记住这个位置。
   *   注意一点，要求的返回值是每一块的长度，而不是index，所以还要记录上一次切割的位置用来减掉。
   *
   * @param S
   * @return
   */
  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new ArrayList<>();
    if (null == S || S.length() == 0) {
      return result;
    }
    int[] lastIndex = new int[26];

    for (int i = 0; i < S.length(); i++) {
      lastIndex[S.charAt(i)-'a'] = i;
    }

    int start = 0;
    int end = 0;
    for (int i = 0; i < S.length(); i++) {

      end = Math.max(end, lastIndex[S.charAt(i)-'a']);
      if (end == i) {
        result.add(end - start + 1);
        start++;
      }
    }
    return result;
  }
}
