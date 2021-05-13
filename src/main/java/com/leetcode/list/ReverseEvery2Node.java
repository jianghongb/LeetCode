package com.leetcode.list;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * e.g, 1 -> 2-> 3 -> 4  =====> 2 -> 1 -> 4 -> 3
 */
public class ReverseEvery2Node {

  public ListNode reverse(ListNode head) {
    ListNode dummyNode = new ListNode(0); // 设置一个虚拟节点
    dummyNode.next = head;  //将虚拟节点指向head

    ListNode cur = dummyNode;
    while (cur.next != null && cur.next.next != null) {
      // 记录两个虚拟节点
      ListNode tmp = dummyNode.next;
      ListNode tmp1 = dummyNode.next.next.next;
      // d   tmp       tmp1
      // 0 -> 1 -> 2 -> 3 -> 4
      cur.next = cur.next.next; //步骤1
      cur.next.next = tmp;  //步骤2
      cur.next.next.next = tmp1; //步骤3

      cur = cur.next.next;  //移动两位 准备下一轮交换

    }
    return dummyNode.next;
  }
}
