package com.leetcode.list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //        ListNode listNode1 = l1, listNode2 = l2;

        ListNode lc = new ListNode(-1);
        ListNode head = lc;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lc.next = l1;
                l1 = l1.next;
            } else {
                lc.next = l2;
                l2 = l2.next;
            }
            lc = lc.next;
        }

        if (l2 != null) {
            lc.next = l2;
        }
        if (l1 != null) {
            lc.next = l1;
        }
        return head.next;
    }
}
