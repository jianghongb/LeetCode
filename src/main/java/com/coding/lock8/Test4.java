package com.coding.lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {

  public static void main(String[] args) {
    Phone4 phone1 = new Phone4();
    Phone4 phone2 = new Phone4();
    // 我们这里两个线程使用的是两个对象 先调用者先执行
    new Thread(() -> { // Ò»¿ªÊ¼¾ÍÖ´ÐÐÁË
      phone1.sendEmail();
    }, "A").start();
    // ¸ÉÈÅ
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> { // Ò»ÃëºóÖ´ÐÐ
      phone2.sendMS();
    }, "B").start();
  }
}

// 手机，发短信，发邮件
class Phone4 {

  // 被 synchronized 修饰的方法、锁的对象是方法的调用者、调用者不同，没有关系，量个方法用
  //  得不是同一个锁！
  public synchronized void sendEmail() {
    // 善意的延迟
    try {
      TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("sendEmail");
  }

  public synchronized void sendMS() {
    System.out.println("sendMS");
  }
}
