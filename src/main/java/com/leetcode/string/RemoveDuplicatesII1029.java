package com.leetcode.string;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesII1029 {

  public String removeDuplicates(String s, int k) {

    Stack<Character> charSt = new Stack<>();
    Stack<Integer> countSt = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (charSt.size() > 0 && charSt.peek() == ch) {
        countSt.push(countSt.peek() + 1);
      } else {
        countSt.push(1);
      }

      charSt.push(ch);
      if (countSt.peek() == k) {
        for (int i = 0; i < k; i++) {
          charSt.pop();
          countSt.pop();
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (charSt.size() > 0) {
      sb.append(charSt.pop());
    }
    return sb.reverse().toString();
  }

  // 这个算法实现的有问题：不能解决中间存在间隔的情况，扫描过的结果不会再重新计算
  public String removeDuplicates2(String s, int k) {

    int len = 0, top = -1;
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (top >= 0 && res.charAt(top) == ch) {
        len++;
        res.append(ch);
        top++;
        if (len == k) {
          res.delete(res.length() - k, res.length());
          top = res.length() - 1;
          len -= k;
        }
      } else {
        len = 1;
        res.append(ch);
        top++;
      }
    }
    return res.toString();
  }

  @Test
  void test() {
    System.out.println(removeDuplicates2("deeedbbcccbdaa", 3));
  }
}
