package Leetcode_Problems.ReversePartOfALinkedList;


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

  public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        ListNode i = head;
        ListNode j = head;

        ListNode prev = new ListNode();
        ListNode tail = new ListNode();

        while(i != null && left > 1)
        {
            prev = i;
            i = i.next;
            left--;
        }

        while(j != null && right > 1)
        {
            j = j.next;
            tail = j.next;
            right--;
        }
        ListNode curr = i;
        newHead = i;

        while(i != null && i != j)
        {
            curr = new ListNode(i.val);
            curr = curr.next;
        }


    }
    
}
