package Leetcode_Problems.PopulatingNextRightPointer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
}

public class PopulatingNextPointer2 {
   

    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        List<Node> l = new ArrayList<>();
        List<List<Node>> res = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node d = q.poll();
                temp.add(d);
                if(d.left!=null)
                {
                    q.offer(d.left);
                }
                if(d.right != null)
                {
                    q.offer(d.right);
                }
                
            }
            res.add(new ArrayList<>(temp));
        }

        
    }


    
}
