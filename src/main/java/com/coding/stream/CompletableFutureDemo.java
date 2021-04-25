package com.coding.stream;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

  public static void main(String[] args) {
    CompletableFuture<Integer> uCompletableFuture =
        CompletableFuture.supplyAsync(() -> {
          System.out.println(Thread.currentThread().getName() + " 有返回值");
          // int i = 10/0;
          return 1024;
        });
    System.out.println(uCompletableFuture.whenComplete((t, u) -> { //
      System.out.println("=t==" + t); // 正常结果
      System.out.println("=u==" + u); // 错误信息
    }).exceptionally(e -> {
      System.out.println("getMessage=>" + e.getMessage());
      return 555;
    }));
  }
}
