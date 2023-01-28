package Leetcode_Problems.CloneGraph;

import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph2 {
    public Node cloneGraph2(Node node) {
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node(node.val);

        q.add(node);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node d = q.poll();
                for(int j = 0; j < d.neighbors.size(); j++) {
                    
                }
            }

        } 

        
        
    }
}
