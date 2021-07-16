package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1: 1-> 2-> 3-> 3-> 4-> 4-> -5
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2: 1-> 1-> 1-> 2-> 3
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesII82 {

  public ListNode deleteDuplicates(ListNode head) {
    //use two pointers, slow - track the node before the dup nodes,
    // fast - to find the last node of dups.
    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
    slow.next = fast;

    while (fast != null) {
      while (fast.next != null && fast.val == fast.next.val) {
        fast = fast.next;    //while loop to find the last node of the dups.
      }
      if (slow.next != fast) { //duplicates detected.
        slow.next = fast.next; //remove the dups.
        fast = slow.next;     //reposition the fast pointer.
      } else { //no dup, move down both pointer.
        slow = slow.next;
        fast = fast.next;
      }

    }
    return dummy.next;
  }

  public ListNode deleteDuplicates3(ListNode head) {
    Set<Integer> set = new HashSet<>();
    ListNode pre = null;
    ListNode fakeHead = head;
    while (fakeHead != null) {
      if (!set.add(fakeHead.val)) {
        pre.next = fakeHead.next;
      } else {
        pre = fakeHead;
      }
      fakeHead = fakeHead.next;
    }
    return head;
  }

  @Test
  void test() {
    ListNode head = new ListNode(1);
    ListNode head2 = new ListNode(2);
    ListNode head3 = new ListNode(3);
    ListNode head4 = new ListNode(3);
    ListNode head5 = new ListNode(4);
    ListNode head6 = new ListNode(4);
    ListNode head7 = new ListNode(5);
    head.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;
    head5.next = head6;
    head6.next = head7;

    ListNode listNode = deleteDuplicates(head);
    while (listNode != null) {
      System.out.print(listNode.val + ", ");
      listNode = listNode.next;
    }
  }
}
