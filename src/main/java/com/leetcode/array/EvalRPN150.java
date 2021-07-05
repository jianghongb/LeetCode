package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 *
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvalRPN150 {

  public int evalRPN(String[] tokens) {

    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {

      if (!isOperator(token)) {
        stack.push(parseInt(token));
      } else if ("+".equals(token)) {
        stack.push(stack.pop() + stack.pop());
      } else if ("-".equals(token)) {
        stack.push(-stack.pop() + stack.pop());
      } else if ("*".equals(token)) {
        stack.push(stack.pop() * stack.pop());
      } else {
        Integer num2 = stack.pop();
        Integer num1 = stack.pop();
        stack.push(num1 / num2);
      }
    }
    return stack.peek();
  }

  private boolean isOperator(String s) {
    return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
  }

  private Integer parseInt(String s) {
    return Integer.parseInt(s);
  }

  public int evalRPN2(String[] tokens) {
    Deque<Integer> stack = new LinkedList();
    for (String token : tokens) {
      char c = token.charAt(0);
      if (!isOpe(token)) {
        stack.addFirst(stoi(token));
      } else if (c == '+') {
        stack.push(stack.pop() + stack.pop());
      } else if (c == '-') {
        stack.push(-stack.pop() + stack.pop());
      } else if (c == '*') {
        stack.push(stack.pop() * stack.pop());
      } else {
        int num1 = stack.pop();
        int num2 = stack.pop();
        stack.push(num2 / num1);
      }
    }
    return stack.pop();
  }

  private boolean isOpe(String s) {
    return s.length() == 1 && s.charAt(0) < '0' || s.charAt(0) > '9';
  }

  private int stoi(String s) {
    return Integer.valueOf(s);
  }

  public int evalRPN3(String[] tokens) {
    int[] stack = new int[tokens.length];
    int pointer = -1;
    for (String token : tokens) {
      if (token.equals("+")) {
        stack[pointer - 1] += stack[pointer--];
      } else if (token.equals("-")) {
        stack[pointer - 1] -= stack[pointer--];
      } else if (token.equals("*")) {
        stack[pointer - 1] *= stack[pointer--];
      } else if (token.equals("/")) {
        stack[pointer - 1] /= stack[pointer--];
      } else {
        stack[++pointer] = Integer.parseInt(token);
      }
    }
    return stack[pointer];
  }

  @Test
  void test() {
    String[] tokens = { "4", "13", "5", "/", "+" };
    System.out.println(evalRPN2(tokens));
    System.out.println(evalRPN(tokens));
  }
}
