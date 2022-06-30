package Leetcode_Problems.CopyListWithRandomPointer;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    HashMap<Node, Node> hm = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }
        hm.put(null, null);
        Node cur = head;
        while(cur != null)
        {
            Node copy = new Node(cur.val);
            hm.put(cur, copy);
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null)
        {
            Node copy = hm.get(cur);
            copy.next  = hm.get(cur.next);
            copy.random = hm.get(cur.random);
            cur = cur.next;
        }
        return hm.get(head);


        
    }

    
}
