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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode l3 =  new ListNode();
        ListNode h = l3;
        
        int sum = 0;
        
        while(temp1 != null || temp2 != null)
        {
            int a = temp1==null? 0: temp1.val;
            int b = temp2==null? 0: temp2.val;
            sum = a + b + carry;
            
            if(sum > 9)
            {
                carry = 1;
                sum = sum % 10;
            }
            else
            {
                carry = 0;
            }
            // l3.val = sum;
             l3.next = new ListNode(sum);
            l3 = l3.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(carry > 0)
        {
            l3.next = new ListNode(carry);
        }
        
        return h.next;
    }
    
    
    
}
