package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 *
 * Example 1:
 * 1 -> 2 -> 2 -> 1
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * 1 -> 2
 * Input: head = [1,2]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 */
public class PalindromeLinkedList234 {

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    // this is reversed head
    ListNode newHead = null;
    ListNode fast = head;

    while (fast != null) {
      if (fast.next == null) {
        head = head.next;
        break;
      } else {
        fast = fast.next.next;
      }

      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }

    while (newHead != null) {
      if (newHead.val != head.val)
        return false;
      newHead = newHead.next;
      head = head.next;
    }

    return true;
  }

  public static boolean isPalindrome2(ListNode head) {

    if (head == null) {
      return false;
    }
    List<Integer> val = new ArrayList<>();

    while (head != null) {
      val.add(head.val);
      head = head.next;
    }
    /**
     * 可以有优化为下面的代码
     */
    //    int mid = val.size() / 2;
    //    for (int i = 0; i <= mid; i++) {
    //      int j = val.size() - 1 - i;
    //      if (val.get(i) != val.get(j) && i != j) {
    //        return false;
    //      }
    //    }

    int start = 0;
    int end = val.size() - 1;
    while (start < end) {
      if (!val.get(start).equals(val.get(end)))
        return false;
      start++;
      end--;
    }
    return true;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode c = head;
    head.next = new ListNode(2);
    head = head.next;
    head.next = new ListNode(3);
    head = head.next;
    head.next = new ListNode(2);
    head = head.next;
    head.next = new ListNode(1);
    isPalindrome(c);
  }
}
