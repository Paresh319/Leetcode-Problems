package Leetcode_Problems.FlattenADoublyLinkedList;

class Node {
    public Node(int val2) {
        val = val2;
    }
    public Node(){}
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class FlattenADoublyLinkedList {
    Node res = new Node();
    public Node flatten(Node head) {
        Node newHead = res;
        Node curr = head;
        Node prev = null;
        recursiveHelper(curr);
        curr = newHead.next;
        while(curr != null)
        {
            curr.prev = prev;
            prev = curr;
            curr = curr.next;
        }
        return newHead.next;
    }
    
    public void recursiveHelper(Node curr)
    {
        while(curr != null)
        {
            if(curr.child == null)
            {
                res.next = new Node(curr.val);
                // res.prev = prev;
                // prev = res;
                res = res.next;
                curr = curr.next;
            }
            else
            {
                res.next = new Node(curr.val);
                res = res.next;
                recursiveHelper(curr.child);
                curr = curr.next;
            }
        }
    }
    
}
