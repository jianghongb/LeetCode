package com.leetcode.string;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings415 {

    public String addStrings(String num1, String num2) {

        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int digit = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {

            int sum = digit;
            if (i >= 0) {
                sum += (num1.charAt(i--) - '0');
            }

            if (j >= 0) {
                sum += (num2.charAt(j--) - '0');
            }
            digit = sum / 10;
            result.append(sum % 10);

        }
        if (digit > 0) {
            result.append(digit);
        }
        return result.reverse().toString();
    }

    public String addStringsFast(String num1, String num2) {
        int carry = 0, idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            if (idx1 >= 0)
                carry += num1.charAt(idx1--) - '0';
            if (idx2 >= 0)
                carry += num2.charAt(idx2--) - '0';
            sb.append((char) (carry % 10 + '0'));
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
