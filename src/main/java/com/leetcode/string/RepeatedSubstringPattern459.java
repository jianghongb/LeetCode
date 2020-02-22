package com.leetcode.string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern459 {

    public boolean repeatedSubstringPattern(String s) {
        int[] lps = new int[s.length()];
        int i = 1;
        for (int j = 0; i < s.length(); ) {//
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j != 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        if (lps[lps.length - 1] == 0)
            return false;

        int patternlength = s.length() - lps[lps.length - 1];

        if (s.length() % patternlength == 0)
            return true;

        return false;
    }

}
