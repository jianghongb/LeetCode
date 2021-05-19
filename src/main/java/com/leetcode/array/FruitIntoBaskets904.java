package com.leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 *
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 *
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 *
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 *
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 *
 * Note:
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */
public class FruitIntoBaskets904 {

  public int totalFruit1(int[] tree) {
    int start = 0, end = 0, distinctC = 0, len = 0;
    int[] freq = new int[40000 + 1];
    while (end < tree.length) {
      if (freq[tree[end++]]++ == 0) {
        distinctC++;
      }

      while (distinctC > 2) {
        if (freq[tree[start++]]-- == 1) {
          distinctC--;
        }
      }
      len = Math.max(len, end - start);
    }
    return len;

  }

  public int totalFruit(int[] tree) {
    int max = 0;
    int curMax = 0;
    int prev = -1; // last value
    int prev2 = -1; // 2nd last value
    int prevCount = 0; // no. of occurrences of prev

    for (int fruit : tree) {
      if (fruit == prev || fruit == prev2) {
        // cur value is the same we have in the two baskets?
        curMax++;
      } else {
        // update max and curMax
        max = Math.max(max, curMax);
        curMax = prevCount + 1;
      }

      if (fruit == prev) {
        // same as previous?
        prevCount++;
      } else {
        prevCount = 1;
        // swap prev and prev2
        prev2 = prev;
        prev = fruit;
      }
    }
    return Math.max(max, curMax);
  }

  public int totalFruit3(int[] tree) {
    int last_fruit = -1;
    int second_last_fruit = -1;
    int cur_max = 0;
    int max = 0;
    int last_fruit_count = 0;

    for (int fruit : tree) {
      if (fruit == last_fruit || fruit == second_last_fruit) {
        cur_max++;
      } else {
        cur_max = last_fruit_count + 1;
      }

      if (fruit == last_fruit) {
        last_fruit_count++;
      } else {
        last_fruit_count = 1;
      }

      if (fruit != last_fruit) {
        second_last_fruit = last_fruit;
        last_fruit = fruit;
      }

      max = Math.max(max, cur_max);
    }

    return max;
  }

  @Test
  void test() {
    int[] nums = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
    System.out.println(totalFruit3(nums));
  }
}
