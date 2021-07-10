package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class TopKFrequentWords692 {

  class Node {

    String word;
    int count;

    public Node(String word, int count) {
      this.word = word;
      this.count = count;
    }
  }

  public List<String> topKFrequent(String[] words, int k) {
    List<String> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    Queue<Node> pq = new PriorityQueue<>((a, b) ->
        a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count
    );

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for (String word : map.keySet()) {
      pq.add(new Node(word, map.get(word)));
    }

    while (k-- > 0) {
      res.add(pq.poll().word);
    }
    return res;
  }

  /**
   *   这个实现有个小问题： 就是同样frequency的word 顺序可能会和正确结果顺序不一致
   * @param words
   * @param k
   * @return
   */
  public List<String> topKFrequent2(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    Queue<String> stack = new PriorityQueue<>(Comparator.comparingInt(map::get));

    for (String key : map.keySet()) {
      stack.add(key);
      while (!stack.isEmpty() && stack.size() > k) {
        stack.poll();
      }
    }
    String[] res = new String[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = stack.poll();
    }
    return Arrays.stream(res).collect(Collectors.toList());
  }

  @Test
  void test() {
    String[] words = { "i", "love", "leetcode", "i", "love", "coding" }
        /*{ "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }*/;
    int k = 2;
    for (String s : topKFrequent2(words, k)) {
      System.out.println(s + ",");
    }
  }
}
