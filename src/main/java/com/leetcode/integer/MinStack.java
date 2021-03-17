package com.leetcode.integer;

import java.util.Arrays;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * -----------------------------------------------------------
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * 思路：
 *   1、 用数组Integer[]存储，push检查是否需要扩容，pop 检查是否缩容量，getMin 每次都需要遍历 思考是否可以优化
 *   2、 用Stack<Integer> 存储，这个要怎么实现？
 */
class MinStack {

  private Integer[] stack;
  private int LENGTH = 5;
  private int size;
  private int min = Integer.MAX_VALUE;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new Integer[LENGTH];
  }

  public void push(int val) {
    int tmp = size + 1;
    if (tmp > stack.length) {
      //extends the stack size
      int newLen = stack.length * 2;
      stack = Arrays.copyOf(stack, newLen);
    }
    stack[size++] = val;
    if (val < min) {
      min = val;
    }
  }

  public void pop() {
    int idx = size - 1;
    if (idx < 0) {
      return;
    }
    stack[idx] = null;
    size--;
    if (size < LENGTH) {
      stack = Arrays.copyOf(stack, LENGTH);
    }
  }

  public int top() {
    if (size <= 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return stack[size - 1];

  }

  public int getMin() {
    int min = 0;
    if (size <= 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    //    min = stack[0];
    //    for (int i = 1; i < size; i++) {
    //      if (min > stack[i]) {
    //        min = stack[i];
    //      }
    //    }
    return min;
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-1);
    int test = minStack.getMin();
    System.out.println(test);
    test = minStack.top();    // return 0
    minStack.pop();
    System.out.println(test);
    test = minStack.getMin(); // return -2
    System.out.println(test);
  }
}

