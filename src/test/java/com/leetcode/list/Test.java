package com.leetcode.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {


        public static void main(String[] args) {
            System.out.println(new B().getValue());
        }
        static class A {
            protected int value;
            public A (int v) {
                setValue(v);
            }
            public void setValue(int value) {
                this.value= value;
            }
            public int getValue() {
                try {
                    value ++;
                    return value;
                } finally {
                    this.setValue(value);
                    System.out.println(value);
                }
            }
        }
        static class B extends A {
            public B () {
                super(5);
                setValue(getValue()- 3);
            }
            public void setValue(int value) {
                super.setValue(2 * value);
            }
        }


    public static void main3(String[] args) {
        byte a1 = 2, a2 = 4, a3;
         short s = 16;
        // a2 = s;
        // a3 = a1 * a2;
//         int x=1;
        float f[][] = new float[6][6];
        float []f1[] = new float[6][6];
        float [][]f3 = new float[6][6];
        float f4[][] = new float[6][];
        float f6[][] = new float[6][6];

        printDefaultCapacityList();
        printEmptyCapacityList();
    }

    public static void printDefaultCapacityList() {
        ArrayList defaultCapacity = new ArrayList();
        System.out.println(
            "default 初始化长度：" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
            "default add 之后 长度：" + getCapacity(defaultCapacity));
    }

    public static void printEmptyCapacityList() {
        ArrayList emptyCapacity = new ArrayList(0);
        System.out.println(
            "empty 初始化长度：" + getCapacity(emptyCapacity));

        emptyCapacity.add(1);
        System.out.println(
            "empty add 之后 长度：" + getCapacity(emptyCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // 获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            // 开启访问权限
            field.setAccessible(true);
            // 把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main2(String[] args) {
        HashMap<Integer, String> test
            = new HashMap<>();
        test.put(1, "1");
        test.put(2, "2");
        test.put(3, "3");
        test.put(4, "4");
        test.put(5, "5");
        test.put(6, "6");
        test.put(7, "7");
        test.put(8, "8");
        test.put(11, "1");
        test.put(12, "2");
        test.put(13, "3");
        test.put(14, "4");
        test.put(15, "5");
        test.put(16, "6");
        test.put(17, "7");
        test.put(18, "8");
        test.put(111, "1");
        test.put(112, "2");
        test.put(113, "3");
        test.put(114, "4");
        test.put(115, "5");
        test.put(116, "6");
        test.put(117, "7");
        test.put(118, "8");

        System.out.println(test.get("1"));
        //        String[] A = new String[] { "amazon", "apple", "facebook", "google", "leetcode" };
        //        String[] B = new String[] { "e", "oo" };
//        int[] b = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//        int[] a = new int[] { -2 };
//        MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
//        maximumSubarray53.maxSubArray(a);
        //        QuickSort sortColors = new QuickSort();
        //        sortColors.quickSort(a);
        //        Arrays.stream(a).forEach(x -> System.out.println(x + ""));

    }

    static class Person {

        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
