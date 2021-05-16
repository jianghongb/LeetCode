package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements347 {

  public int[] topKFrequent2(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == -1 || k > nums.length) {
      return null;
    }

    // O(1) time
    if (k == nums.length) {
      return nums;
    }

    // 1. build hash map : character and how often it appears
    // O(N) time
    Map<Integer, Integer> count = new HashMap();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    Queue<Integer> heap = new PriorityQueue<>(
        Comparator.comparingInt(count::get));

    // 2. keep k top frequent elements in the heap
    // O(N log k) < O(N log N) time
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    // 3. build an output array
    // O(k log k) time
    int[] top = new int[k];
    for (int i = k - 1; i >= 0; --i) {
      top[i] = heap.poll();
    }
    return top;
  }

  public int[] topKFrequent3(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    LinkedList<Integer> list = new LinkedList(map.keySet());
    Collections.sort(list, (w1, w2) -> map.get(w2) - map.get(w1));

    // 3. build an output array
    // O(k log k) time
    int[] top = new int[k];
    for (int i = k - 1; i >= 0; --i) {
      top[i] = list.get(i);
    }
    return top;

  }

  int[] unique;
  Map<Integer, Integer> count;

  public void swap(int a, int b) {
    int tmp = unique[a];
    unique[a] = unique[b];
    unique[b] = tmp;
  }

  public int partition(int left, int right, int pivot_index) {
    int pivot_frequency = count.get(unique[pivot_index]);
    // 1. move pivot to end
    swap(pivot_index, right);
    int store_index = left;

    // 2. move all less frequent elements to the left
    for (int i = left; i <= right; i++) {
      if (count.get(unique[i]) < pivot_frequency) {
        swap(store_index, i);
        store_index++;
      }
    }

    // 3. move pivot to its final place
    swap(store_index, right);

    return store_index;
  }

  public void quickselect(int left, int right, int k_smallest) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

    // base case: the list contains only one element
    if (left == right)
      return;

    // select a random pivot_index
    Random random_num = new Random();
    int pivot_index = left + random_num.nextInt(right - left);

    // find the pivot position in a sorted list
    pivot_index = partition(left, right, pivot_index);

    // if the pivot is in its final sorted position
    if (k_smallest == pivot_index) {
      return;
    } else if (k_smallest < pivot_index) {
      // go left
      quickselect(left, pivot_index - 1, k_smallest);
    } else {
      // go right
      quickselect(pivot_index + 1, right, k_smallest);
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    count = new HashMap();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // array of unique elements
    int n = count.size();
    unique = new int[n];
    int i = 0;
    for (int num : count.keySet()) {
      unique[i] = num;
      i++;
    }

    // kth top frequent element is (n - k)th less frequent.
    // Do a partial sort: from less frequent to the most frequent, till
    // (n - k)th less frequent element takes its place (n - k) in a sorted array.
    // All element on the left are less frequent.
    // All the elements on the right are more frequent.
    quickselect(0, n - 1, n - k);
    // Return top k frequent elements
    return Arrays.copyOfRange(unique, n - k, n);
  }

  @Test
  void test() {
    int[] nums = { 5, 3, 1, 1, 1, 3, 73, 1 };
    int k = 1;
    int[] topKFrequent = topKFrequent(nums, k);
    for (int i = 0; i < topKFrequent.length; i++) {
      System.out.print(topKFrequent[i] + ",");
    }
  }
}
