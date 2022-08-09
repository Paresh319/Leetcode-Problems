package Leetcode_Problems.ReOrderList;

import java.util.ArrayList;
import java.util.List;

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class ReorderList {
    public void reorderList(ListNode head) {
        List<List<ListNode>> l = new ArrayList<>();
        int n = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }

        int i = 1; 
        int j = n;
        ListNode slow = head;
        ListNode fast = head;

        while(i <= j){
            
            for(int k = 1; k < i; k++){
                slow = slow.next;
            }
            
            for(int k = 1; k < j; k++){
                fast = fast.next;
            }
            
            i++;
            j--;
            List<ListNode> temp = new ArrayList<>();
            temp.add(slow);
            temp.add(fast);
            l.add(new ArrayList<ListNode>(temp));
            slow = head;
            fast = head;
        }

        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for(List<ListNode> p: l){
            for(ListNode a: p)
            {
                t.next = a;
                t = a;
            }
        }
        t.next = null;
    }
}
