package Leetcode_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    List<List<Integer>> res = new ArrayList();
    List<Integer> l = new ArrayList();
     HashMap<Integer, List<Integer>> hm;
    public List<List<Integer>> findLeaves(TreeNode root) {
        
       hm = new HashMap();
        
        traversal(root);
        System.out.println(hm);
        for(List<Integer> a: hm.values())
        {
            res.add(new ArrayList<Integer>(a));
        }
        
        return res;
        
    }
    
    public int traversal(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        int lHeight = traversal(root.left);
        int rHeight = traversal(root.right);
        
        int height = Math.max(lHeight, rHeight) + 1;
        
        
        if(hm.containsKey(height))
        {
            hm.get(height).add(root.val);
        }
        else
        {
            List<Integer> l = new ArrayList();
            l.add(root.val);
            hm.put(height, l);
        }
        return height;
        
    }
    
}
