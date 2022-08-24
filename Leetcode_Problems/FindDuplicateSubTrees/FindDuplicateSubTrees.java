package Leetcode_Problems.FindDuplicateSubTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class FindDuplicateSubTrees {
    HashMap<String, Integer> hm = new HashMap<>();
    List<TreeNode> res = new ArrayList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postorder(root);
        return res;
    
        
    }
    
    public String postorder(TreeNode root)
    {
        if(root == null)
        {
            return "#";
        }
        
        String s = root.val + ","+ postorder(root.left) + "," + postorder(root.right);
        hm.put(s, hm.getOrDefault(s, 0) + 1);
        if(hm.get(s) == 2)
        {
            res.add(root);
        }
        return s;
    }
}
