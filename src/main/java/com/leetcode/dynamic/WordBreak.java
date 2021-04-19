package com.leetcode.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int maxLength = 0;

    for (String word : wordDict) {
      maxLength = Math.max(maxLength, word.length());
    }

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i < s.length(); i++) {
      int j = i;
      while (j >= 0 && j > i - maxLength) {
        if (set.contains(s.substring(j, i + 1)) && dp[j]) {
          dp[i + 1] = true;
        }
        j--;
      }
    }

    return dp[s.length()];
  }

  public boolean wordBreak2(String s, List<String> wordDict) {
    Boolean[] memo = new Boolean[s.length()];
    Set<String> dict = new HashSet<>(wordDict);
    return helper(s, dict, 0, memo);
  }

  private boolean helper(String s, Set<String> dict, int start, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    boolean isValid = false;
    for (int i = start; i < s.length(); i++) {
      if (dict.contains(s.substring(start, i + 1))) {
        if (helper(s, dict, i + 1, memo)) {
          isValid = true;
          break;
        }
      }
    }
    memo[start] = isValid;
    return memo[start];
  }
}
