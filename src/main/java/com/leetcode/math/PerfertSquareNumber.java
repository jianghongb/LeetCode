package com.leetcode.math;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 *
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 */
public class PerfertSquareNumber {

  public boolean isPerfectSquare(int x) {
    if (x <= 0) {
      return false;
    }
    long r = x;
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return r * r == x;
  }

  public boolean isPerfectSquare2(int num) {
    if (num < 1)
      return false;
    long left = 1, right = num;// long type to avoid 2147483647 case

    while (left <= right) {
      long mid = left + (right - left) / 2;
      long t = mid * mid;
      if (t > num) {
        right = mid - 1;
      } else if (t < num) {
        left = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
