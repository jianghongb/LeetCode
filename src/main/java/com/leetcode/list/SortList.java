package com.leetcode.list;

import java.util.List;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 *
 *
 * Example 1:
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 */
public class SortList {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge2(left, right);
  }

  ListNode merge2(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tail.next = list1;
        list1 = list1.next;
        tail = tail.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
        tail = tail.next;
      }
    }
    tail.next = (list1 != null) ? list1 : list2;
    return dummyHead.next;
  }

  ListNode getMid(ListNode head) {
    ListNode midPrev = null;
    while (head != null && head.next != null) {
      midPrev = (midPrev == null) ? head : midPrev.next;
      head = head.next.next;
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    return mid;
  }

  public ListNode sortList0(ListNode head) {

    if (null == head || head.next == null) {
      return head;
    }

    ListNode p = head;
    ListNode next = head.next;
    while (next != null) {

      if (next.val < head.val) {
        ListNode tmp = next.next;
        head.next = tmp;
        next.next = head;
        head = next;
        next = tmp;
      }
      if (next.val >= head.val && head.next != next) {
        head = head.next;
      } else {
        head = next;
        next = next.next;
      }
    }
    return p;
  }

  ListNode tail = new ListNode();
  ListNode nextSubList = new ListNode();

  public ListNode sortList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    int n = getCount(head);
    ListNode start = head;
    ListNode dummyHead = new ListNode();
    for (int size = 1; size < n; size = size * 2) {
      tail = dummyHead;
      while (start != null) {
        if (start.next == null) {
          tail.next = start;
          break;
        }
        ListNode mid = split(start, size);
        merge(start, mid);
        start = nextSubList;
      }
      start = dummyHead.next;
    }
    return dummyHead.next;
  }

  ListNode split(ListNode start, int size) {
    ListNode midPrev = start;
    ListNode end = start.next;
    //use fast and slow approach to find middle and end of second linked list
    for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
      if (end.next != null) {
        end = (end.next.next != null) ? end.next.next : end.next;
      }
      if (midPrev.next != null) {
        midPrev = midPrev.next;
      }
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    nextSubList = end.next;
    end.next = null;
    // return the start of second linked list
    return mid;
  }

  void merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode newTail = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        newTail.next = list1;
        list1 = list1.next;
        newTail = newTail.next;
      } else {
        newTail.next = list2;
        list2 = list2.next;
        newTail = newTail.next;
      }
    }
    newTail.next = (list1 != null) ? list1 : list2;
    // traverse till the end of merged list to get the newTail
    while (newTail.next != null) {
      newTail = newTail.next;
    }
    // link the old tail with the head of merged list
    tail.next = dummyHead.next;
    // update the old tail to the new tail of merged list
    tail = newTail;
  }

  int getCount(ListNode head) {
    int cnt = 0;
    ListNode ptr = head;
    while (ptr != null) {
      ptr = ptr.next;
      cnt++;
    }
    return cnt;
  }
}

