package Leetcode_Problems.PopulatingNextRightPpointersII;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointerII {
    public Node connect(Node root) {
        if(root == null)
        {
            return root;
        }
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                
            
                Node d = q.poll();
                if(i < size - 1)
                {
                    d.next = q.peek();
                }
                if(d.left != null)
                {
                    q.offer(d.left);
                }
                if(d.right != null)
                {
                    q.offer(d.right);
                }
            }
        }
        return root;
        
    }
    
}
