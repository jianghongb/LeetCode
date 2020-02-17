package com.leetcode.list;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        int add = 0;
        while (l1 != null || l2 != null) {
            int sum = l1.val + l2.val + add;
            add = sum / 10;
            l1.val = sum % 10;
            l3.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        while (l1 != null) {
            int sum = l1.val + add;
            add = sum / 10;
            l1.val = sum % 10;
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }
        while (l2 != null) {
            int sum = l2.val + add;
            add = sum / 10;
            l2.val = sum % 10;
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }

        if (add > 0) {
            l3.next = new ListNode(add);
        }
        return head.next;
    }
}
