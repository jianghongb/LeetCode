package com.design.pattern;

public class Singleton {

  /**
   * 饿汉模式的线程安全同样通过类加载解决同步问题，但没有达到懒加载目的。
   */
  //  private static Singleton instance = new Singleton();
  //
  //  public static Singleton getInstance() {
  //    return instance;
  //  }

  /**
   * 懒汉模式(多线程不安全)
   */
  //  private static Singleton instance;
  //
  //  public static Singleton getInstance() {
  //    if (instance == null) {
  //      instance = new Singleton();
  //    }
  //    return instance;
  //  }

  /**
   * 枚举方式：(多线程安全) 虽然线程安全，在实际开发中，还没有被广泛采用。
   * 因为太过简洁以致于可读性较差，还没有在实战中被广泛推广。枚举单例模式的线程安全同样利用静态内部类中讲到类初始化锁。
   * 枚举单例模式能够在序列化和反射中保证实例的唯一性。
   */
  //  enum Single {
  //    INSTANCE;
  //
  //    public void doSomething() {
  //      //todo doSomething
  //    }
  //  }

  /**
   * 线程安全: 双检查模式
   * 推荐理由：
   *
   * 延迟初始化。和懒汉模式一致，只有在初次调用静态方法getSingleton，才会初始化signleton实例。
   * 性能优化。同步会造成性能下降，在同步前通过判读singleton是否初始化，减少不必要的同步开销。
   * 线程安全。同步创建Singleton对象，同时注意到静态变量singleton使用volatile修饰。
   *
   * 为什么要使用volatile修饰？
   * 虽然已经使用synchronized进行同步，但在第4步创建对象时，会有下面的伪代码
   * ------------------------------------------------------
   * memory=allocate(); //1：分配内存空间
   * ctorInstance();   //2:初始化对象
   * singleton=memory; //3:设置singleton指向刚排序的内存空间
   * ------------------------------------------------------
   * 当线程A在执行上面伪代码时，2和3可能会发生重排序，因为重排序并不影响运行结果，还可以提升性能，所以JVM是允许的。
   * 如果此时伪代码发生重排序，步骤变为1->3->2,线程A执行到第3步时，线程B调用getsingleton方法，在判断
   * singleton==null时不为null，则返回singleton。但此时singleton并还没初始化完毕，线程B访问的将是个还没初始化完毕的对象。
   * 当声明对象的引用为volatile后，伪代码的2、3的重排序在多线程中将被禁止!
   */
  //  private static volatile Singleton instance;  //1:volatile修饰
  //  public static Singleton getInstance() {
  //
  //    if (instance == null) { //2:减少不要同步，优化性能
  //      synchronized (Singleton.class) {  // 3：同步，线程安全
  //        if (instance == null) {
  //          instance = new Singleton();  //4：创建singleton 对象
  //        }
  //      }
  //    }
  //    return instance;
  //  }

  /**
   * 静态内部类：线程安全
   * 推荐理由：
   *
   * 实现代码简洁。和双重检查单例对比，静态内部类单例实现代码真的是太简洁，又清晰明了。
   * 延迟初始化。调用getSingleton才初始化Singleton对象。
   * 线程安全。JVM在执行类的初始化阶段，会获得一个可以同步多个线程对同一个类的初始化的锁。
   *
   * 如何实现线程安全？
   * 线程A和线程B同时试图获得Singleton对象的初始化锁，假设线程A获取到了，那么线程B一直等待初始化锁。
   * 线程A执行类初始化，就算双重检查模式中伪代码发生了重排序，也不会影响线程A的初始化结果。初始化完后，释放锁。
   * 线程B获得初始化锁，发现Singleton对象已经初始化完毕，释放锁，不进行初始化，获得Singleton对象。
   * 在涉及到反射和序列化的单例中，建议使用下文的枚举类型模式
   */
  public static Singleton getInstance() {
    return Inner.instance;
  }

  static class Inner {

    private static final Singleton instance = new Singleton();
  }
}
