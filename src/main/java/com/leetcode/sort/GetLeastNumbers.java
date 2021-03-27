package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbers {

  /**
   * 冒泡排序，复杂度为O(n*k)
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] solution1(int[] nums, int k) {
    if (nums == null || nums.length < k) {
      return new int[] {};
    }

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int tmp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = tmp;
        }
      }
    }
    return Arrays.copyOf(nums, k);
  }

  /**
   * 堆排序，可以采用库函数中的优先队列（PriorityQueue） 。
   * PriorityQueue的底层原理就是一个堆排序，它可以帮助我们不需要手写堆排序的算法，就能实现堆排序的功能，应用中很方便。
   * 可以参考：https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc
   *
   * @param input
   * @param k
   * @return
   */
  public ArrayList<Integer> solution(int[] input, int k) {
    ArrayList<Integer> res = new ArrayList<>();

    if (input == null || input.length < k || k < 0) {
      return res;
    }
    Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

    for (int i = 0; i < input.length; i++) {
      if (queue.size() < k) {
        queue.add(input[i]);
      } else {
        if (input[i] < queue.peek()) {
          queue.remove();         //如果小于堆顶元素，则将堆顶元素去掉
          queue.add(input[i]);   //将数字插入当前堆中，PriorityQueue会自动重新建堆
        }
      }
    }
    while (!queue.isEmpty()) {
      res.add(queue.remove());
    }
    return res;
  }

  public static ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
    ArrayList<Integer> resultList = new ArrayList<Integer>();
    if (input.length <= 0 || k <= 0) {
      return resultList;
    }
    TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    for (int i = 0; i < input.length; i++) {
      if (i < k) {
        set.add(input[i]);
      } else {
        if (set.first() > input[i]) {
          set.remove(set.first());
          set.add(input[i]);
        }
      }
    }
    if (!set.isEmpty()) {
      resultList.addAll(set);
    }
    Collections.reverse(resultList);
    return resultList;
  }
}
