package com.leetcode.list;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class LinkedListCycle141 {

    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && first.next != null) {
            if (first == second) {
                return true;
            } else {
                first = first.next;
                second = second.next;
            }
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
            if (fast == head) {
                return true;
            }
        }
        return false;
    }

}
