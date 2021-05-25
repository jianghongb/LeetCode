package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class IsAnagram242 {

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      Character ch = t.charAt(i);
      if (map.get(ch) == null) {
        return false;
      } else {
        map.put(ch, map.getOrDefault(ch, 0) - 1);
      }
    }
    for (Character key : map.keySet()) {
      if (map.get(key) != 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }

    int[] map = new int[26];

    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < t.length(); i++) {
      map[t.charAt(i) - 'a']--;
    }

    for (int idx : map) {
      if (idx != 0) {
        return false;
      }
    }
    return true;
  }

  @Test
  void test() {
    String s = "cat";
    String t = "car";
    isAnagram(s, t);
  }
}
