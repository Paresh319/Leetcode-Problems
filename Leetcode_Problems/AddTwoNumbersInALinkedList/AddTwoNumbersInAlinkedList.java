package Leetcode_Problems.AddTwoNumbersInALinkedList;

import java.util.List;

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
public class AddTwoNumbersInAlinkedList 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseLinkedList(l1);
        ListNode node2 = reverseLinkedList(l2);

        int carry = 0;
        int sum = 0;
        while(node1 != null || node2 != null)
        {
            int a = node1 != null? node1.val: 0;
            int b = node2 != null? node2.val: 0;

            sum += a+ b + carry;

            if(sum > 9)
            {
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            
        }
        return node1;
        
    }


    public ListNode reverseLinkedList(ListNode head)
    {
        ListNode prev = null;
        ListNode next = null;

        ListNode curr = head;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
    
}
