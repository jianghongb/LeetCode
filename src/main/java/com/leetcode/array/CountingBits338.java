package com.leetcode.array;

/**
 * Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].
 *
 * https://leetcode.com/problems/counting-bits/
 *
 * Example 1:
 *
 * Input: num = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 *
 * Input: num = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 *
 * 0 <= num <= 105
 */
public class CountingBits338 {

  public static int[] countBits2(int num) {
    if (num < 0) {
      return null;
    }
    int[] result = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      if (i == 0) {
        result[0] = 0;
      } else if (i == 1) {
        result[1] = 1;
      } else {
        int count = 0;
        if (i % 2 != 0) {
          count++;
        }
        int build = i;
        while (build / 2 != 0) {
          int tmp = build / 2;
          if (tmp == 1) {
            count++;
          } else if (tmp % 2 != 0) {
            count++;
          }
          build = tmp;
        }
        result[i] = count;
      }
    }
    return result;
  }

  public static int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      res[i] = res[i & (i - 1)] + 1;
    }
    return res;
  }

  public static int[] countBits3(int num) {
    int[] res = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      res[i] = res[i / 2] + i % 2;
    }
    return res;
  }

  public static void main(String[] args) {
    int num = 9;
    for (int i : countBits(num)) {
      System.out.print(i + ",");
    }
  }
}
