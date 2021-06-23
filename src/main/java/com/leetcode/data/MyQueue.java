package com.leetcode.data;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 *
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
class MyQueue {

  Stack<Integer> in;
  Stack<Integer> out;

  /**
   * Initialize your data structure here.
   */
  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    in.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    int res = out.pop();
    while (!out.isEmpty()) {
      in.push(out.pop());
    }
    return res;
  }

  /**
   * Get the front element.
   */
  public int peek() {
    while (!in.isEmpty()) {
      out.push(in.pop());
    }
    int res = out.peek();
    while (!out.isEmpty()) {
      in.push(out.pop());
    }
    return res;
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return in.isEmpty();
  }

  @Test
  void test() {
    MyQueue obj = new MyQueue();
    obj.push(1);
    obj.push(2);
    int param_3 = obj.peek();
    System.out.println(param_3);
    int param_2 = obj.pop();
    System.out.println(param_2);
    boolean param_4 = obj.empty();
    System.out.println(param_4);
  }
}

class MyQueue2 {

  Stack<Integer> in;
  Stack<Integer> out;

  /**
   * Initialize your data structure here.
   */
  public MyQueue2() {
    in = new Stack<>();
    out = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    in.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    dumpStack();
    return out.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    dumpStack();
    return out.peek();
  }

  private void dumpStack() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }

  @Test
  void test() {
    MyQueue obj = new MyQueue();
    obj.push(1);
    obj.push(2);
    int param_3 = obj.peek();
    System.out.println(param_3);
    int param_2 = obj.pop();
    System.out.println(param_2);
    boolean param_4 = obj.empty();
    System.out.println(param_4);
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
