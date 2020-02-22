package com.leetcode.string;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementStrstr28 {

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    // Here we use the kmp to solve this problem
    private int[] computeLPS(String str) { // computes Longest Prefix Suffix (LPS) array
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int i = 1; // always walks forward
        int j = 0; // tracks prefix that matches suffix

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else { // mismatch
                if (j == 0) { // go onto next character in string
                    lps[i] = 0;
                    i++;
                } else { // backtrack j to check previous matching prefix
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }

    int strStr3(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        }

        int[] lps = computeLPS(needle);
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // match found. Return location of match
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1]; // backtrack j to check previous matching prefix
                }
            }
        }

        return -1; // did not find needle
    }
}
