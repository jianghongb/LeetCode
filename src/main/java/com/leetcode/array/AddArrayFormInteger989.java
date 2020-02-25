package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 *
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 *
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Example 4:
 *
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 */
public class AddArrayFormInteger989 {

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = K + A[i];
            K = sum / 10;
            result.add(sum % 10);
        }
        while (K > 0) {
            result.add(K % 10);
            K = K / 10;
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> addToArrayFormFast(int[] A, int K) {
        List<Integer> list = new LinkedList<>();

        int i = A.length - 1;
        int carry = 0;
        while (i >= 0 || K != 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) {
                sum += A[i];
                i--;
            }
            if (K != 0) {
                sum += K % 10;
                K = K / 10;
            }
            list.add(0, sum % 10);
            carry = sum / 10;
        }

        return list;
    }

    public List<Integer> addToArrayFormNo1(int[] A, int K) {
        Deque<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.offerFirst((A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.offerFirst(K % 10);
            K /= 10;
        }
        return (List) res;
    }
}
