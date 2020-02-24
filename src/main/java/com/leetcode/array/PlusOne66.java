package com.leetcode.array;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne66 {

    public int[] plusOne(int[] digits) {

        if (null == digits || digits.length == 0) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }

        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int[] plusOne2(int[] digits) {
        if (null == digits || digits.length == 0) {
            return digits;
        }

        int digit = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + digit;
            digits[i] = tmp % 10;
            digit = tmp / 10;
            if (digit == 0) {
                break;
            }
        }
        if (digit == 1) {
            int[] result = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            result[0] = digit;
            return result;
        }
        return digits;
    }
}
