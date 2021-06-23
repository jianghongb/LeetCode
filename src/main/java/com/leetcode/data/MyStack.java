package com.leetcode.data;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 *
 * Notes:
 *
 * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.
 */
class MyStack2 {

  private final Queue<Integer> in;
  private final Queue<Integer> out;

  /**
   * Initialize your data structure here.
   */
  public MyStack2() {
    in = new LinkedList();
    out = new LinkedList();
  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {
    in.offer(x);
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    while (!in.isEmpty() && in.size() != 1) {
      out.offer(in.poll());
    }
    int res = in.poll();
    if (in.isEmpty()) {
      while (!out.isEmpty()) {
        in.offer(out.poll());
      }
    }
    return res;
  }

  /**
   * Get the top element.
   */
  public int top() {

    int res = this.pop();
    this.push(res);
    return res;
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return in.isEmpty();
  }
}

class MyStack {

  private Queue<Integer> q1 = null, q2 = null;
  private Integer topElement = null;

  /**
   * Initialize your data structure here.
   */
  public MyStack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {
    if (q1.isEmpty()) {
      q2.add(x);
    } else {
      q1.add(x);
    }
    topElement = x;
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    if (q1.isEmpty()) {
      return drainAndRturnLast(q2, q1);
    } else {
      return drainAndRturnLast(q1, q2);
    }
  }

  /**
   * Get the top element.
   */
  public int top() {
    if (topElement == null)
      throw new EmptyStackException();
    return topElement;
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }

  public int drainAndRturnLast(Queue<Integer> srcq, Queue<Integer> dstq) {
    if (srcq.isEmpty())
      throw new EmptyStackException();
    for (int size = srcq.size(); size > 1; size--) {
      topElement = srcq.remove();
      dstq.add(topElement);
    }
    return srcq.remove();
  }
}

class MyStack3 {

  private Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack3() {
    queue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
    int l = queue.size();
    while (l-- > 1) {
      queue.offer(queue.poll());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
