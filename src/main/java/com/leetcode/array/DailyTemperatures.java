package com.leetcode.array;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Given a list of daily temperatures temperatures, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return temperatures;
    }
    int[] result = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      int day = temperatures[i];
      int j = i + 1;
      while (j < temperatures.length) {
        if (day < temperatures[j]) {
          result[i] = j - i;
          break;
        }
        j++;
      }
    }

    return result;
  }

  public int[] dailyTemperatures2(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return temperatures;
    }
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) { //单调栈，如果当天气温高于stack里的温度，把index相减
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int day = stack.pop(); //stack里被poll出来的天数
        res[day] = i - day; // 把当天和之前的天数差值存到res里
      }
      stack.push(i); //这里不能用add();
    }
    return res;
  }

  @Test
  void test() {
    int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
    int[] result = dailyTemperatures2(temperatures);
    for (int i : result) {
      System.out.print(i + ", ");

    }
  }
}
