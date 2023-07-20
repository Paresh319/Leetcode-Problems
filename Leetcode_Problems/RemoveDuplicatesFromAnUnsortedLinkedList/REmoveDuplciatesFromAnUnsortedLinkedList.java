package Leetcode_Problems.RemoveDuplicatesFromAnUnsortedLinkedList;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 */
   class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class REmoveDuplciatesFromAnUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, Integer> valueCountMap = new HashMap<>();
        ListNode current = head;

        // Count the occurrences of each node's value
        while (current != null) {
            valueCountMap.put(current.val, valueCountMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        // Remove nodes with duplicate values
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        current = dummy;

        while (current.next != null) {
            if (valueCountMap.get(current.next.val) > 1) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
