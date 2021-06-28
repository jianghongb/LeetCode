package com.leetcode.weibag;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
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
public class WordBreak139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];

    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {

        String word = s.substring(j, i);
        if (wordDict.contains(word) && dp[j]) {
          dp[i] = true;
        }
      }
    }
    return dp[s.length()];
  }

  public boolean wordBreak2(String s, List<String> wordDict) {
    return dfs(s, 0, wordDict, new Boolean[s.length()]);
  }

  private boolean dfs(String s, int currIndex, List<String> words, Boolean[] memo) {
    if (currIndex == s.length()) {
      return true;
    }

    if (memo[currIndex] != null)
      return memo[currIndex];

    for (String word : words) {
      if (s.startsWith(word, currIndex)) {
        if (dfs(s, currIndex + word.length(), words, memo)) {
          memo[currIndex] = true;
          return true;
        }
      }
    }

    memo[currIndex] = false;
    return false;
  }

  /**
   * Time: O(N^N) since each time it has at most N choices and the depth (problem size) is N. (this is an upper bound)
   * Space: O(N) (string length and call stack depth)
   * <p>
   *   Time Limit Exceeded
   * </p>
   *
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreak3(String s, List<String> wordDict) {
    return backtracing(s, wordDict, 0);
  }

  private boolean backtracing(String s, List<String> wordDict, int startIdx) {
    if (s.length() == startIdx) {
      return true;
    }

    for (int i = startIdx; i < s.length(); i++) {
        String tmp = s.substring(startIdx, i+1);
        if(wordDict.contains(tmp) && backtracing(s, wordDict, i+1)){
          return true;
        }
    }
    return false;
  }

  @Test
  void test() {
    String s = "catsandog";
    List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(wordBreak(s, wordDict));
  }

}
