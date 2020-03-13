package com.leetcode.string;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }

            }
        }
        return strs[0];
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        int n = Math.min(strs[0].length(), strs[strs.length - 1].length());
        String str = "";
        for (int i = 0; i < n; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                str += strs[0].charAt(i);
            } else {
                return str;
            }
        }
        return str;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        return prefix;
    }
}
