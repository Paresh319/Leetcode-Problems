package Leetcode_Problems.AllNodesDistanceKInABinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

public class AllNodesDistanceKInABinaryTree {
    List<Integer> res;
    HashMap<TreeNode, List<TreeNode>> hm = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<Integer>();
        if(root == null)
        {
            return res;
        }
        buildGraph(root, null);
        // System.out.println(hm);
        
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        HashSet<TreeNode> hs = new HashSet();
        hs.add(target);
        
        q.offer(target);
        while(!q.isEmpty())
        {
            int size = q.size();
            if(k == 0)
            {
                for(int i = 0; i < size; i++)
                {
                    res.add(q.poll().val);
                }
                return res;
            }
            for(int i = 0; i < size; i++)
            {
                TreeNode d = q.poll();
                for(TreeNode temp: hm.get(d))
                {
                    if(!hs.contains(temp))
                    {
                        q.offer(temp);
                        hs.add(temp);
                    }
                }
            }
            k--;
        }
        return res;
    }
    
    public void buildGraph(TreeNode root, TreeNode parent)
    {
        if(root == null)
        {
            return;
        }
        if(!hm.containsKey(root))
        {
            hm.put(root, new ArrayList<TreeNode>());
            if(parent != null)
            {
                hm.get(root).add(parent);
                hm.get(parent).add(root);
            }
            buildGraph(root.left, root);
            buildGraph(root.right, root);
        }
        
    }
}
