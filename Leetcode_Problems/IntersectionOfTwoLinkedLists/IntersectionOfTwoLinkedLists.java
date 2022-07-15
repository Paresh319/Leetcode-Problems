package Leetcode_Problems.IntersectionOfTwoLinkedLists;

import java.util.HashSet;
 class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet();
        ListNode curr= headA;
        while(curr != null)
        {
            hs.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while(curr != null)
        {
            if(hs.contains(curr))
            {
                return curr;
            }
            curr = curr.next;
        }
        return null;
        
    }
}
