package com.leetcode.list;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度O(1)的解法么？
 */
public class HasCycle {

  public boolean hasCycle(ListNode head) {
    ListNode p = head;
    while (p != null) {
      ListNode after = p.next;
      if (after == p) {
        return true;
      }
      p.next = head;
      p = after;
    }
    return false;
  }
}
