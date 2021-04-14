package com.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程分别打印A，B，C，要求这三个线程一起运行，打印n次，输出形如“ABCABCABC....”的字符串。
 */
public class PrintABCUsingLock {

  /**
   * 1. 解法一：使用Lock
   */
  private int times;
  private int state;
  private Lock lock = new ReentrantLock();

  public PrintABCUsingLock(int times) {
    this.times = times;
  }

  public static void main(String[] args) {
    PrintABCUsingLock printABC = new PrintABCUsingLock(10);
    new Thread(printABC::printA).start();
    new Thread(printABC::printB).start();
    new Thread(printABC::printC).start();
  }

  public void printA() {
    print("A", 0);
  }

  public void printB() {
    print("B", 1);
  }

  public void printC() {
    print("C", 2);
  }

  private void print(String name, int targetState) {
    for (int i = 0; i < times; ) {
      lock.lock();
      if (state % 3 == targetState) {
        state++;
        i++;
        System.out.print(name);
      }
      lock.unlock();
    }
  }
}

class PrintABCUsingSemaphore {

  private int times;
  private Semaphore semaphoreA = new Semaphore(1);
  private Semaphore semaphoreB = new Semaphore(0);
  private Semaphore semaphoreC = new Semaphore(0);

  public PrintABCUsingSemaphore(int times) {
    this.times = times;
  }

  public static void main(String[] args) {
    PrintABCUsingSemaphore printABC = new PrintABCUsingSemaphore(10);
    new Thread(printABC::printA).start();
    new Thread(printABC::printB).start();
    new Thread(printABC::printC).start();
  }

  public void printA() {
    try {
      print("A", semaphoreA, semaphoreB);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void printB() {
    try {
      print("B", semaphoreB, semaphoreC);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void printC() {
    try {
      print("C", semaphoreC, semaphoreA);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void print(String name, Semaphore current, Semaphore next)
      throws InterruptedException {
    for (int i = 0; i < times; i++) {
      current.acquire();
      System.out.print(name);
      next.release();
    }
  }
}
