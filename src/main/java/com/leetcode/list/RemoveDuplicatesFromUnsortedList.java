package com.leetcode.list;

import org.junit.jupiter.api.Test;

/**
 * Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
 *
 * Return the linked list after the deletions.
 *
 * Example 1: 1-> 2-> 3-> 2
 *
 * Input: head = [1,2,3,2]
 * Output: [1,3]
 * Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
 *
 * Example 2: 2-> 1-> 1-> 2
 *
 * Input: head = [2,1,1,2]
 * Output: []
 * Explanation: 2 and 1 both appear twice. All the elements should be deleted.
 *
 * Example 3: 3-> 2-> 2-> 1-> 3-> 2-> 4
 *
 * Input: head = [3,2,2,1,3,2,4]
 * Output: [1,4]
 * Explanation: 3 appears twice and 2 appears three times. After deleting all 3's and 2's, we are left with [1,4].
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105]
 * 1 <= Node.val <= 105
 */
public class RemoveDuplicatesFromUnsortedList {

  /**
   * 从一个未排序的链表中移除重复的节点。
   *
   * 题意是给一个单链表，链表中的 node.val 是乱序的，请你找到那些 val 出现次数超过一次的 node 并将他们删去，返回删除后的链表。
   *
   * 思路是需要扫描两遍，这里我们同时需要一个 hashmap 记录每个不同 node.val 的出现次数。第一遍扫描的时候记录每个不同 node.val 的出现次数，第二遍扫描的时候，需要创建一个新的 dummy 节点，用dummy.next去试探下一个节点是否是需要删除的节点，如果是，就直接跳过即可。
   *
   * 时间O(n)
   *
   * 空间O(n)
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicatesUnsorted(ListNode head) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    int[] map = new int[(int) Math.pow(10, 5) + 1];
    // dummy - 最后需要return用的
    // dummy2 - 第二遍扫描的时候需要用的，因为涉及到删除操作，所以只能用.next试探
    ListNode dummy = new ListNode(0);
    ListNode dummy2 = dummy;
    dummy.next = head;

    ListNode cur = head;
    while (cur != null) {
      // map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
      map[cur.val]++;
      cur = cur.next;
    }

    while (dummy2.next != null) {
      // if (map.getOrDefault(dummy2.next.val, 0) > 1) {
      if (map[dummy2.next.val] > 1) {
        dummy2.next = dummy2.next.next;
      } else {
        dummy2 = dummy2.next;
      }
    }
    return dummy.next;
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

    ListNode listNode = deleteDuplicatesUnsorted(head);
    while (listNode != null) {
      System.out.print(listNode.val + ", ");
      listNode = listNode.next;
    }
  }
}
