package com.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Hanno {

  public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
    int n = A.size();
    move(A, B, C, n);
  }

  private void move(List<Integer> left, List<Integer> tmp, List<Integer> right, int num) {
    if (num == 1) {
      Integer value = left.remove(0);
      right.add(0,value);
      return;
    }
    move(left, right, tmp, num - 1);
    Integer value = left.remove(0);
    right.add(0,value);
    move(tmp, left, right, num - 1);
  }

  @Test
  void test() {
    List<Integer> A = new ArrayList<>();
    A.add(2);
    A.add(1);
    A.add(0);
    List<Integer> B = new ArrayList<>();
    List<Integer> C = new ArrayList<>();
    hanota(A,B,C);
    C.forEach(i -> System.out.print(i+", "));
  }
}
