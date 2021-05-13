package com.coding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface MyInterface {

  void doSomething();
}

class MyInterfaceImpl implements MyInterface {

  @Override
  public void doSomething() {
    System.out.println("Do something !");
  }
}

public class MyInvocationHandler implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Arrays.stream(Thread.currentThread()
        .getStackTrace())
        .forEach(System.out::println);
    System.out.println(method);

    System.out.println("------The invoked method: " + method);
    return null;
  }

  public static void main(String[] args) {
    MyInvocationHandler handler = new MyInvocationHandler();

    MyInterface o = (MyInterface) Proxy.newProxyInstance(
        MyInvocationHandler.class.getClassLoader(),
        new Class[] { MyInterface.class }, handler);
    o.doSomething();
  }

}
