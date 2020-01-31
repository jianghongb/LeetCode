package com.leetcode.list;


public class ReverseLinkedList206 {

    ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverserd = null,
                p = null;

        while (head != null) {
            ListNode next = head.next;
            if (head.next == null) {
                reverserd = head;
            }

            head.next = p;
            p = head;
            head = next;

        }
        return reverserd;
    }

    ListNode reverseList3(ListNode head) {

        if (null == head) {
            return head;
        }
        ListNode node = head,
                prev = null,
                reversed = null;

        while (node != null) {
            ListNode next = node.next;
            if (node.next == null) {
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversed;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode r_head = reverseList2(next);
        next.next = head;
        head.next = null;
        return r_head;
    }

    void test() {
        int[] nums = new int[] { 2, 3, 4, 5 };
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;

        }
        ListNode listNode = reverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
//Reverse either iteratively or recursively. Could you implement both?

// Definition for singly-linked list.

