package com.leetcode.dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinations {

  private static final Map<Character, List<Character>> KEYBOARD = new HashMap<>();

  static {
    KEYBOARD.put('2', Arrays.asList('a', 'b', 'c'));
    KEYBOARD.put('3', Arrays.asList('d', 'e', 'f'));
    KEYBOARD.put('4', Arrays.asList('g', 'h', 'i'));
    KEYBOARD.put('5', Arrays.asList('j', 'k', 'l'));
    KEYBOARD.put('6', Arrays.asList('m', 'n', 'o'));
    KEYBOARD.put('7', Arrays.asList('p', 'q', 'r', 's'));
    KEYBOARD.put('8', Arrays.asList('t', 'u', 'v'));
    KEYBOARD.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (!digits.isEmpty()) {
      dfs(digits, 0, new StringBuilder(), combinations);
    }
    return combinations;
  }

  /**
   * Time complexity: O(4**N).
   * Space complexity: O(N).
   *
   * @param digits
   * @param i
   * @param current
   * @param combinations
   */
  private void dfs(String digits, int i, StringBuilder current, List<String> combinations) {
    if (i == digits.length()) {
      combinations.add(current.toString());
    } else {
      for (char c : KEYBOARD.get(digits.charAt(i))) {
        dfs(digits, i + 1, current.append(c), combinations);
        current.deleteCharAt(i);
      }
    }
  }

  public List<String> letterCombinations2(String digits) {
    if (digits.isEmpty()) {
      return new ArrayList<>();
    }
    return bfs(digits);
  }

  /**
   * Time complexity: O(4**N).
   * Space complexity: O(4**N).
   *
   * @param digits
   * @return
   */
  private List<String> bfs(String digits) {
    Queue<StringBuilder> queue = new ArrayDeque<>();
    queue.add(new StringBuilder());
    for (int i = 0; i < digits.length(); i++) {
      char digit = digits.charAt(i);
      int size = queue.size();
      while (size-- > 0) {
        StringBuilder prefix = queue.remove();
        for (char letter : KEYBOARD.get(digit)) {
          queue.add(new StringBuilder(prefix).append(letter));
        }
      }
    }

    List<String> combinations = new ArrayList<>(queue.size());
    while (!queue.isEmpty()) {
      combinations.add(queue.remove().toString());
    }
    return combinations;
  }
}
