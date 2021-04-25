package com.coding.lock;

public class RTLock {

  public static void main(String[] args) {
    Phone phone = new Phone();
    new Thread(() -> {
      phone.sendMs();
    }, "T1").start();
    new Thread(() -> {
      phone.sendMail();
    }, "T2").start();
  }
}

class Phone {

  public synchronized void sendMs() {
    System.out.println(Thread.currentThread().getName() + " sendMs");
    sendMail();
  }

  public synchronized void sendMail() {
    System.out.println(Thread.currentThread().getName() + " sendMail");
  }
}
