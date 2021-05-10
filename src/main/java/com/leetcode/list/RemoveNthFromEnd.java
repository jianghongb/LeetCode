package com.leetcode.list;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n < 0) {
      return null;
    }

    ListNode p = head;
    int count = 0;
    while (p != null) {
      p = p = p.next;
      count++;
    }

    if (count == n && n == 1) {
      return head.next;
    }
    p = head;
    for (int i = 0; i < count - n - 1; i++) {
      head = head.next;

    }
    ListNode next = head.next;
    head.next = next.next;
    return p;
  }

  public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode prev, slow, fast;
    slow = head;
    fast = head;
    prev = null;
    while (n-- > 0) {
      fast = fast.next;
    }
    // 记住 待删除节点slow 的上一节点
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
    }
    if (prev == null) {
      return head.next;
    }
    // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
    prev.next = slow.next;
    return head;
  }

  @Test
  void test() {
    ListNode p = new ListNode(1);
    ListNode p2 = new ListNode(2);
    //    ListNode p3 = new ListNode(3);
    //    ListNode p4 = new ListNode(4);
    //    ListNode p5 = new ListNode(5);
    p.next = p2;
    //    p2.next = p3;
    //    p3.next = p4;
    //    p4.next = p5;

    ListNode listNode = removeNthFromEnd2(p, 1);
    if (listNode == null) {
      System.out.println("[]");
    }
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }
}
