package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 22. Generate Parentheses
 * Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParenthesis {

  /**
   * Approach 2: Backtracking
   *
   * Intuition and Algorithm
   *
   * Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence. We can do this by keeping track of the number of opening and closing brackets we have placed so far.
   *
   * We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.
   *
   * @param n
   * @return
   */
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, "", 0, 0, n);
    return result;
  }

  public void backtrack(List<String> output_arr, String currrent_string, int open, int close, int max) {
    if (currrent_string.length() == max * 2) {
      output_arr.add(currrent_string);
      return;
    }

    if (open < max) {
      backtrack(output_arr, currrent_string + "(", open + 1, close, max);
    }
    if (close < open) {
      backtrack(output_arr, currrent_string + ")", open, close + 1, max);
    }
  }

  /**
   * Intuition
   *
   * To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.
   *
   * Consider the closure number of a valid parentheses sequence S: the least index >= 0 so that S[0], S[1], ..., S[2*index+1] is valid. Clearly, every parentheses sequence has a unique closure number. We can try to enumerate them individually.
   *
   * Algorithm
   *
   * For each closure number c, we know the starting and ending brackets must be at index 0 and 2*c + 1. Then, the 2*c elements between must be a valid sequence, plus the rest of the elements must be a valid sequence.
   *
   * @param n
   * @return
   */
  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList();
    if (n == 0) {
      ans.add("");
    } else {
      for (int c = 0; c < n; ++c) {
        for (String left : generateParenthesis2(c)) {
          for (String right : generateParenthesis2(n - 1 - c)) {
            ans.add("(" + left + ")" + right);
          }
        }
      }
    }
    return ans;
  }

  @Test
  void test(){
    generateParenthesis2(2).stream().forEach(System.out::print);
  }
}
