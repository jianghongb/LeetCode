package com.coding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 每一个动态代理类都必须要实现InvocationHandler 这个接口，并且每个代理类的实
 * 例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就
 * 会被转发为由InvocationHandler 这个接口的invoke 方法来进行调用。我们来看看Inv
 * ocationHandler 这个接口的唯一一个方法invoke 方法
 * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 * proxy: 指代我们所代理的那个真实对象
 * method: 指代的是我们所要调用真实对象的某个方法的Method 对象
 * args: 指代的是调用真实对象某个方法时接受的参数
 */
public class JdkProxyDemo {

  interface If {

    void originalMethod(String s);
  }

  static class Original implements If {

    public void originalMethod(String s) {
      System.out.println(s);
    }
  }

  static class Handler implements InvocationHandler {

    private final If original;

    public Handler(If original) {
      this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
        throws IllegalAccessException, IllegalArgumentException,
        InvocationTargetException {
      System.out.println("BEFORE");
      method.invoke(original, args);
      System.out.println("AFTER");
      System.out.println("this is Handler invoke method");
      return null;
    }
  }

  public static void main(String[] args) {
    Original original = new Original();
    Handler handler = new Handler(original);
    If f = (If) Proxy.newProxyInstance(If.class.getClassLoader(),
        new Class[] { If.class },
        handler);
    f.originalMethod("Hallo");
  }

}
