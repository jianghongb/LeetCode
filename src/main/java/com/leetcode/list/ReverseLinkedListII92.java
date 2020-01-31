package com.leetcode.list;

public class ReverseLinkedListII92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || !(1 <= m && m <= n)) {
            return null;
        }
        int count = 0;
        ListNode reversed = null, mpre = null, mnext = null,
                npre=null, nnext=null;
        ListNode mnode=null,nnode = null;

        while (head != null) {
            ListNode next = head.next;
            ++ count ;
            if (head.next == null) {
                reversed = head;
            }
            if(count == m){
                mpre = head;
                mnode = head.next;
                mnext = head.next.next;
            }



        }
        return reversed;
    }
}
