package com.leetcode.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Node {

  public int key, val;
  public Node next, prev;

  public Node(int k, int v) {
    this.key = k;
    this.val = v;
  }
}

class DoubleList {

  Node head = new Node(0, 0);
  Node tail = new Node(0, 0);
  int size;

  DoubleList() {
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  void addFirst(Node n) {
    Node headNext = head.next;
    head.next = n;
    headNext.prev = n;
    n.prev = head;
    n.next = headNext;
    size++;
  }

  void remove(Node n) {
    n.prev.next = n.next;
    n.next.prev = n.prev;
    size--;
  }

  Node removeLast() {
    Node last = tail.prev;
    remove(last);
    return last;
  }

  int size() {
    return size;
  }

}

class LRUCache {

  // key -> Node(key, val)
  private final Map<Integer, Node> map;
  // node(k1, v1) <-> Node(k2, v2)...
  private final DoubleList cache;
  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
    cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    int val = map.get(key).val; // 利⽤ put ⽅法把该数据提前
    put(key, val);
    return val;
  }

  public void put(int key, int value) {
    Node n = new Node(key, value);
    if (map.containsKey(key)) {
      cache.remove(map.get(key));
      cache.addFirst(n);
      map.put(key, n);
    } else {
      if (cache.size() == capacity) {
        // delete last element in list
        Node last = cache.removeLast();
        map.remove(last.key);
      }
      cache.addFirst(n);
      map.put(key, n);
    }
  }
}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {

  private final int capacity;

  public LRUCache2(int capacity) {
    super(capacity, 0.75F, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }
}




