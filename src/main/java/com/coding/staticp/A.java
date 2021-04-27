package com.coding.staticp;

class A {

  //  test3： 静态变量 静态代码块先于sout（“0000”）执行 静态的东西只执行一次 相当于全局变量
  public A() {
    System.out.println("A gouzhao");
  }

  private static final A a = new A();

  static {
    System.out.println("static");
  }

  {
    System.out.println("A1");
  }
  //  test2
  //  {
  //    System.out.println("A");
  //  result is AstaticAB 构造器先于静态代码块执行，静态代码块只执行一次
  //  }
  //  test1
  //  public A(){
  //    System.out.println("A");
  //  result is AstaticAB
  //  }
}

class B extends A {

  public B() {
    System.out.println("B");
  }

  public static void main(String[] args) {
    System.out.println("0000");
    B b = new B();
  }
}
