package com.leetcode.string;

import java.util.StringTokenizer;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {

        if (null == s) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    public int lengthOfLastWord2(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        String p = "";
        while (st.hasMoreTokens()) {
            p = st.nextToken();
        }
        if (p.length() == 0) {
            return 0;
        } else {
            return p.length();
        }
    }
}
