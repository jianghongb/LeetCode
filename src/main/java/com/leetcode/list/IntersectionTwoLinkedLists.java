package com.leetcode.list;

import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * A :              A1 -> A2
 * \
 * C1 ->  C2 -> C3
 * /
 * B :         B1-> B2 -> B3
 *
 * Example 1:
 *
 * 4 -> 1
 * \
 * 8 -》 4 -> 5
 * /
 * 5 -> 6 -> 1
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 *
 * 1 -> 9 -> 1
 * \
 * 2 -> 4
 * /
 * 3
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 *
 * 2 -> 6 -> 4
 *
 * 1 -> 5
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 *
 * Constraints:
 *
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.
 */
public class IntersectionTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (null == headA || null == headB) {
      return null;
    }

    ListNode outer = headA;
    ListNode inner = headB;

    while (outer != null || inner != null) {
      if (outer == inner) {
        return outer;
      }
      outer = outer == null ? headB : outer.next;
      inner = inner == null ? headA : inner.next;

    }
    return null;
  }

  /**
   * Note: In the case lists do not intersect, the pointers for A and B
   *   will still line up in the 2nd iteration, just that here won't be
   *   a common node down the list and both will reach their respective ends
   *   at the same time. So pA will be NULL in that case.
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }

  public int length(ListNode head) {
    int count = 1;
    ListNode curr = head;
    while (curr.next != null) {
      count++;
      curr = curr.next;
    }
    return count;

  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    //for this question, we can first assume that the two list will be
    //intersect each other at some point,
    //so we can first find out the length of the two list first
    //then we move the pointer of the longer list to the difference
    //then we start comparing
    //if the node that we comparing down the list is equal, we return the node
    //if there are no, we then return -1
    int lengthA = length(headA);
    int lengthB = length(headB);

    if (lengthA > lengthB) {
      int difference = lengthA - lengthB;
      while (difference > 0) {
        headA = headA.next;
        difference--;
      }
    } else {
      int difference = lengthB - lengthA;
      while (difference > 0) {
        headB = headB.next;
        difference--;
      }
    }

    while (headB != headA) {
      headB = headB.next;
      headA = headA.next;
    }
    return headA;

  }
}
