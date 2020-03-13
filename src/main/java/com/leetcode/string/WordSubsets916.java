package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * Return a list of all universal words in A.  You can return the words in any order.
 * Example 1:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * Example 3:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 *
 *
 * Example 4: TODO This is not covered in my code
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 */
public class WordSubsets916 {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();

        if (null == A || A.length == 0) {
            return result;
        }

        if (null == B || B.length == 0) {
            return result;
        }
        Arrays.sort(B);
        int max_length = Math.max(B[0].length(), B[B.length - 1].length());
        List<String> blist = new ArrayList<>();
        String s;
        for (int i = 0; i < max_length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (i < B[j].length()) {
                    s = B[j].charAt(i) + "";
                    if (!blist.contains(s)) {
                        blist.add(s);
                    }
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            s = A[i];
            for (int j = 0; j < blist.size(); j++) {
                String bString = blist.get(j);
                if ((s.contains(bString)) && !result.contains(s)) {
                    result.add(s);
                } else if (!(s.contains(bString))) {
                    if (result.contains(s)) {
                        result.remove(s);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public List<String> wordSubsets2(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i) {
                bmax[i] = Math.max(bmax[i], bCount[i]);
            }
        }

        List<String> ans = new ArrayList();
        search:
        for (String a : A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i])
                    continue search;
            }
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c : S.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }
}
