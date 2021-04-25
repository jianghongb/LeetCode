package com.coding.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(5);
    // compareAndSet 简称 CAS 比较并交换！
    // compareAndSet(int expect, int update) 我期望原来的值是什么，如果是，就更新
    System.out.println(atomicInteger.compareAndSet(4,
        2020)+"=>"+atomicInteger.get());
    System.out.println(atomicInteger.compareAndSet(5,
        2020)+"=>"+atomicInteger.get());
    // 2020
    System.out.println(atomicInteger.compareAndSet(2020,
        1024)+"=>"+atomicInteger.get());
  }
}
