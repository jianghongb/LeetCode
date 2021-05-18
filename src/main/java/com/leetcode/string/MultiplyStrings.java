package com.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 给出两个用字符串表示的数字，将两个数字的乘积作为字符串返回。
 * 备注：数字可以无限大，且是非负数。
 * 示例1
 * 输入: "1","2"
 *
 * 返回值: "2"
 */
public class MultiplyStrings {

//  /**
//   * @param num1 string字符串
//   * @param num2 string字符串
//   * @return string字符串
//   */
//  public String multiply(String num1, String num2) {
//    if (null == num1 || num2 == null) {
//      return null;
//    }
//
//    int digit = 0;
//    StringBuilder builder = new StringBuilder();
//    int i = num1.length() - 1;
//    int j = num2.length() - 1;
//
//    while (i >= 0 || j >= 0) {
//      int mul = 1;
//
//      if (i >= 0) {
//        mul = mul * (num1.charAt(i--) - '0');
//      }
//      if (j >= 0) {
//        mul = mul * (num2.charAt(j--) - '0');
//      }
//      builder.append((mul + digit) % 10);
//      digit = mul / 10;
//    }
//    if (digit > 0) {
//      builder.append(digit);
//    }
//    return builder.reverse().toString();
//  }

  /**
   * @param num1 string字符串
   * @param num2 string字符串
   * @return string字符串
   */
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    StringBuilder sb = new StringBuilder();
    int[] tmp = new int[n1 + n2];

    for (int i = n1 - 1; i >= 0; i--) {
      for (int j = n2 - 1; j >= 0; j--) {
        tmp[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }
    int carrybit = 0;//从个位开始，carrybit是进位
    for (int i = tmp.length - 1; i >= 0; i--) {
      tmp[i] += carrybit;
      carrybit = tmp[i] / 10;
      tmp[i] = tmp[i] % 10;

    }
    int left = 0;
    while (left < tmp.length - 1 && tmp[left] == 0)
      left++;
    for (; left < tmp.length; left++) {
      sb.append(tmp[left]);
    }
    return sb.toString();
  }

  @Test
  void test() {
    String num1 = "9", num2 = "99";
    System.out.println(multiply(num1, num2));

  }
}
