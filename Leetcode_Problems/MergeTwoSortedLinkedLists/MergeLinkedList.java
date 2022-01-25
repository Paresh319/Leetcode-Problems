/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode l3 = new ListNode();
        ListNode head = l3;
        
        
        while(l1 != null && l2 != null)
        {
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            if(a <= b)
            {
                l3.next = new ListNode(a);
                l3 = l3.next;
                l1 = l1.next;
            }
            else
            {
                l3.next = new ListNode(b);
                l3 = l3.next;
                l2 = l2.next;
            }
        }
        
        l3.next = l1 == null?l2:l1;
        
        
        return head.next;
        
    }
}
