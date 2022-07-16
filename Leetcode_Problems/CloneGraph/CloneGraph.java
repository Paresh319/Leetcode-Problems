package Leetcode_Problems.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    HashMap<Node, Node> hm = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        if(hm.containsKey(node))
        {
            return hm.get(node);
        }
        Node cloned = new Node(node.val, new ArrayList<>());
        hm.put(node, cloned);
        
        for(Node a: node.neighbors)
        {
            Node clone = cloneGraph(a);
            cloned.neighbors.add(clone);
        }
        return cloned;
        
    }
    
}
