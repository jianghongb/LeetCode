package com.leetcode.string;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it;
 * and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 * passed:
 * 1. abcd/cdabcdab
 * 2. a/a
 * 3. abcabcacabc/abac
 *
 * failed:
 * aa/a
 */
public class RepeatedStringMatch686 {

    /**
     * 题解：
     *
     * A重复append自己知道比B长，看B是否包含在内，若包含返回当前count.
     * 若没有再append次A. 若B能是substring, 这个长度已经可以包含所有可能性. B的开头在0到A.length()-1的任何位置都足够盖住B.
     * Time Complexity: O(A.length()+B.length()). create个长度为A.length()+B.length()的string. 再用B找index.
     * Space: O(A.length()+B.length()).
     *
     * @param A
     * @param B
     *
     * @return count of repeat
     */
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder str = new StringBuilder();
        while (str.length() < B.length()) {
            str.append(A);
            ++count;
        }

        if (str.indexOf(B) >= 0) {
            return count;
        } else if (str.append(A).indexOf(B) >= 0) {
            return count + 1;
        } else {
            return -1;
        }

    }

    public int repeatedStringMatchMax(String A, String B) {
        int subLen = Math.min(A.length(), B.length());
        String sub = B.substring(0, subLen);
        int idx = (A + A).indexOf(sub);
        if (idx < 0) {
            return -1;
        }

        for (int i = 0; i < B.length(); i++) {
            int aIdx = (i + idx) % A.length();
            if (B.charAt(i) != A.charAt(aIdx)) {
                return -1;
            }
        }
        return ((B.length() + idx) + A.length() - 1) / A.length();
    }

    public int repeatedStringMatchMine(String A, String B) {

        if (A == null || B == null) {
            return -1;
        }
        int[] lps = new int[A.length()];
        int count = 0;
        int j = 0, i = 0;
        while (j < B.length()) {
            if (i < A.length()) {
                if (A.charAt(i) == B.charAt(j)) {
                    lps[i] = lps[i] + 1;
                    j++;
                } else {
                    lps[i] = 0;
                }
                i++;
            } else {
                count++;
                i = 0;
            }
        }

        if (lps[lps.length - 1] == 0) {
            return -1;
        }
        return ++count;

    }
}
