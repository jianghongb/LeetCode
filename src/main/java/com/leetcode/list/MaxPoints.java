package com.leetcode.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Point {

  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class MaxPoints {

  @Test
  void test() {
    Point[] points = new Point[2];
    points[0] = new Point(0, 0);
    points[1] = new Point(0, 1);
    System.out.println(maxPoints(points));

  }

  public int maxPoints(Point[] points) {
    if (points.length == 1 || points.length == 2) {
      return points.length;
    }
    int res = 0;
    for (int i = 0; i < points.length - 1; ++i) {
      int a = points[i].x;
      int b = points[i].y;
      for (int j = i + 1; j < points.length; ++j) {
        int aa = points[j].x - a;
        int bb = points[j].y - b;
        int count = 0;
        if (aa == 0 && bb == 0) {
          for (int k = 0; k < points.length; ++k) {
            if (points[k].x == a && points[k].y == b) {
              count++;
            }
          }
        } else {
          for (int k = 0; k < points.length; ++k) {
            if ((points[k].x - a) * bb == (points[k].y - b) * aa) {
              count++;
            }
          }
        }
        res = Math.max(res, count);
      }
    }
    return res;
  }

  public int maxPoints2(Point[] points) {
    // write code here
    int len = points.length;
    if (len <= 2) {
      return len;
    }
    int MAX = 0;
    for (int i = 0; i < len; i++) {//遍历每一个点
      int n1 = 0, n2 = 0, n3 = 0;
      Map<Float, Integer> map = new HashMap<Float, Integer>(); //键：斜率； 值：该斜率下与点i结合的点数
      for (int j = 0; j < len; j++) {//遍历其它点，计算其他点与点i的斜率
        if (i == j) {//1.跳过本次循环
          continue;
        }
        if (points[i].x == points[j].x) {
          if (points[i].y == points[j].y) {//2.点j与当前点i重合
            n2++;
          } else {//3.点j与点i在同一条垂直于x轴的直线上，即斜率不存在
            n1++;
          }
        } else {//4.正常情况下，计算其它点与点i结合后，不同斜率下点的个数
          float k = (float) (points[i].y - points[j].y) / (points[i].x - points[j].x);//斜率(不要忘记强转为float型)
          if (map.get(k) == null) {//当前斜率下，第一次出现
            map.put(k, 1);
          } else {//否则，更新斜率出现的次数
            map.put(k, map.get(k) + 1);
          }
        }//else
      }//for
      //5.通过比较，获取与点i在同一条直线上，最多的点数
      int max = n1;
      for (float f : map.keySet()) {//遍历集合中，所有斜率下的点数。获取出现次数最多的点
        max = Math.max(max, map.get(f));
      }
      MAX = Math.max(MAX, max + n2); //需加上重复出现的点数n2
    }//for
    return MAX + 1;//加上当前的这个点
  }

  public int maxPoints3(Point[] points) {
    if (points == null || points.length == 0)
      return 0;
    if (points.length < 3) {
      return points.length;
    }
    int res = 0;
    for (int i = 1; i < points.length; i++) {
      int a = points[i].x;
      int b = points[i].y;
      int xx = a - points[i - 1].x;
      int yy = b - points[i - 1].y;
      int count = 0;
      if (xx == 0 && yy == 0) {
        for (int j = 0; j < points.length; j++) {
          if (points[j].x == a && points[j].y == b) {
            count++;
          }
        }
      } else {
        for (int j = 0; j < points.length; j++) {
          if ((points[j].x - a) * yy == (points[j].y - b) * xx) {
            count++;
          }
        }
      }
      res = Math.max(res, count);
    }
    return res;
  }
}
