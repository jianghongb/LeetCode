package com.coding.lock8;

import java.util.concurrent.TimeUnit;

public class Test5 {

  public static void main(String[] args) {
    Phone5 phone = new Phone5();
    new Thread(() -> {
      phone.sendEmail();
    }, "A").start();
    // ¸ÉÈÅ
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> { // Ò»ÃëºóÖ´ÐÐ
      phone.sendMS();
    }, "B").start();
  }
}

// 手机，发短信，发邮件
class Phone5 {

  // 对象 类模板可以new 多个对象！
  // Class 类模版，只有一个
  // 被 synchronized 修饰 和 static 修饰的方法，锁的对象是类的 class 对象！唯一的
  // 同一把锁
  public static synchronized void sendEmail() {
    // 善意的延迟
    try {
      TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("sendEmail");
  }

  public static synchronized void sendMS() {
    System.out.println("sendMS");
  }
}
