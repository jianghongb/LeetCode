package com.coding.lock8;

import java.util.concurrent.TimeUnit;

public class Test8 {

  public static void main(String[] args) {
    Phone8 phone = new Phone8();
    Phone8 phone2 = new Phone8();
    new Thread(() -> {
      phone.sendEmail();
    }, "A").start();
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> {
      phone2.sendMS();
    }, "B").start();
  }
}

class Phone8 {

  // CLASS
  public static synchronized void sendEmail() {
    // 善意的延迟
    System.out.println("sendEmail "+ System.currentTimeMillis());
    try {
      TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("sendEmail");
  }

  // 对象
  // 普通同步方法
  public synchronized void sendMS() {
    System.out.println("sendMS "+ System.currentTimeMillis());
  }
}
