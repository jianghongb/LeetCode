package com.leetcode.list;

public class MyLinkedList1 {

  ListNode head;
  ListNode tail;
  int lastIdx;

  /**
   * Initialize your data structure here.
   */
  public MyLinkedList1() {
    this.lastIdx = -1;
    head = new ListNode(0);
    tail = new ListNode(0);
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
   */
  public int get(int index) {
    if (index > lastIdx || index < 0) {
      return -1;
    }
    if (index == 0) {
      return head.next.val;
    }
    if (index == lastIdx) {
      return tail.prev.val;
    }
    ListNode curr = head.next;
    if (index <= lastIdx / 2) {
      for (int i = 0; i < index; i++) {
        curr = curr.next;
      }
    } else {
      curr = tail.prev;
      for (int i = lastIdx; i > index; i--) {
        curr = curr.prev;
      }
    }
    return curr.val;

  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    ListNode toAdd = new ListNode(val);
    head.next.prev = toAdd;
    toAdd.next = head.next;
    head.next = toAdd;
    toAdd.prev = head;
    lastIdx++;
  }

  /**
   * Append a node of value val to the last element of the linked list.
   */
  public void addAtTail(int val) {
    ListNode toAdd = new ListNode(val);
    tail.prev.next = toAdd;
    toAdd.prev = tail.prev;
    toAdd.next = tail;
    tail.prev = toAdd;
    lastIdx++;
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index <= 0) {
      addAtHead(val);
      return;
    }
    if (index == lastIdx + 1) {
      addAtTail(val);
      return;
    }
    ListNode pre, suc;
    if (index <= lastIdx / 2) {
      ListNode curr = head.next;
      for (int i = 0; i < index; i++) {
        curr = curr.next;
      }
      pre = curr.prev;
      suc = curr;
    } else {
      ListNode curr = tail.prev;
      for (int i = lastIdx; i > index; i--) {
        curr = curr.prev;
      }
      suc = curr;
      pre = curr.prev;

    }
    ListNode toAdd = new ListNode(val);
    pre.next = toAdd;
    toAdd.prev = pre;
    toAdd.next = suc;
    suc.prev = toAdd;
    lastIdx++;

  }

  /**
   * Delete the index-th node in the linked list, if the index is valid.
   */
  public void deleteAtIndex(int index) {
    if (index > lastIdx || index < 0) {
      return;
    }
    if (index == 0) {
      head.next.next.prev = head;
      head.next = head.next.next;
    } else if (lastIdx == index) {
      tail.prev.prev.next = tail;
      tail.prev = tail.prev.prev;
    } else if (index <= lastIdx / 2) {
      ListNode curr = head.next;
      for (int i = 0; i < index; i++) {
        curr = curr.next;
      }
      curr.next.prev = curr.prev;
      curr.prev.next = curr.next;
    } else {
      ListNode curr = tail.prev;
      for (int i = lastIdx; i > index; i--) {
        curr = curr.prev;
      }
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }

    lastIdx--;
  }

  class ListNode {

    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }
}
