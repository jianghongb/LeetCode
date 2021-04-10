package com.leetcode.number;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Example 2:
 *
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * Example 3:
 *
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 *
 * Constraints:
 *
 * The input must be a binary string of length 32.
 */
public class NumberofBits {

  /**
   * Approach #1 (Loop and Flip) [Accepted]
   *
   * ** Algorithm**
   *
   * The solution is straight-forward. We check each of the 323232 bits of the number. If the bit is 111, we add one to the number of 111-bits.
   *
   * We can check the ithi^{th}ith bit of a number using a bit mask. We start with a mask m=1m=1m=1, because the binary representation of 111 is,
   *
   * 00000000000000000000000000000001 0000 0000 0000 0000 0000 0000 0000 0001 00000000000000000000000000000001 Clearly, a logical AND between any number and the mask 111 gives us the least significant bit of this number. To check the next bit, we shift the mask to the left by one.
   *
   * 00000000000000000000000000000010 0000 0000 0000 0000 0000 0000 0000 0010 00000000000000000000000000000010
   *
   * And so on.
   *
   * @param n
   * @return
   */
  // you need to treat n as an unsigned value
  public static int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        bits++;
      }
      mask <<= 1;
    }
    return bits;
  }

  public int hammingWeight2(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 00000000000000000000000000001011;

    int i = hammingWeight(n);
    System.out.println(i);
  }
}
