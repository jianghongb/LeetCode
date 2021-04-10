package com.leetcode.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals56 {

  public static int[][] merge0(int[][] intervals) {

    if (intervals == null || intervals.length <= 1) {
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //这条件是必须的 如果没有这个排序 会导致将所有数组合成一个数组
    int size = 1;
    int startIndex = 0;
    int[][] result = new int[intervals.length][2];
    result[startIndex] = intervals[startIndex];
    for (int j = 1; j < intervals.length; j++) {
      int end = result[startIndex][1];
      int start = result[startIndex][0];
      int anotherEnd = intervals[j][1];
      int anotherStart = intervals[j][0];
      if (anotherStart <= end && end <= anotherEnd
          || start <= anotherEnd && anotherEnd <= end) {
        int min = Math.min(start, anotherStart);
        int max = Math.max(end, anotherEnd);
        int[] tmp = { min, max };
        result[startIndex] = tmp;
      } else {
        startIndex++;
        result[startIndex] = intervals[j];
        size++;
      }
    }
    return Arrays.copyOf(result, size);
  }

  public static int[][] merge(int[][] intervals) {

    if (intervals == null || intervals.length <= 1) {
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //这条件是必须的 如果没有这个排序 会导致将所有数组合成一个数组
    int size = 1;
    int startIndex = 0;
    int[][] result = new int[intervals.length][2];
    result[startIndex] = intervals[startIndex];
    for (int j = 1; j < intervals.length; j++) {
      int end = result[startIndex][1];
      int anotherStart = intervals[j][0];
      if (anotherStart <= end) {
        result[startIndex][1] = Math.max(end, intervals[j][1]);
      } else {
        startIndex++;
        result[startIndex] = intervals[j];
        size++;
      }
    }
    return Arrays.copyOf(result, size);
  }

  public static void main(String[] args) {
    int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] res = merge(intervals);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i][0] + "," + res[i][1]);
    }
  }

  public static int[][] merge2(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }

  public int[][] merge3(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> res = new LinkedList<>();

    // 关键是要追踪这个cur, 即使它已经被加进list里了，还是可能会被update.
    int[] cur = intervals[0];

    res.add(cur);
    for (int i = 1; i < intervals.length; i++) {
      int[] next = intervals[i];
      if (cur[1] >= next[0]) {
        cur[1] = Math.max(cur[1], next[1]);
      } else {
        res.add(next);
        cur = next;
      }
    }
    return res.toArray(new int[res.size()][2]);
  }
}
