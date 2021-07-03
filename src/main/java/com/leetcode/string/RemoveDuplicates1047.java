package com.leetcode.string;

import org.junit.jupiter.api.Test;

public class RemoveDuplicates1047 {

  public String removeDuplicates(String s) {
    if (null == s || s.length() == 0) {
      return s;
    }

    int top = -1;
    StringBuilder res = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (top >= 0 && c == res.charAt(top)) {
        res.deleteCharAt(top);
        top--;
      } else {
        res.append(c);
        top++;
      }
    }
    return res.toString();
  }

  public String removeDuplicates2(String s) {
    char[] ch = s.toCharArray();
    int fast = 0;
    int slow = 0;
    while (fast < s.length()) {
      // 直接用fast指针覆盖slow指针的值
      ch[slow] = ch[fast];
      // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
      if (slow > 0 && ch[slow] == ch[slow - 1]) {
        slow--;
      } else {
        slow++;
      }
      fast++;
    }
    return new String(ch, 0, slow);
  }

  @Test
  void test() {
    System.out.println(removeDuplicates2("abbaca"));
  }
}
