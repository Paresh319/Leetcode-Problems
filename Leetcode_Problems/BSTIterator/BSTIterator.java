package Leetcode_Problems.BSTIterator;

import java.util.ArrayList;
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

public class BSTIterator {
    List<Integer> res = new ArrayList<Integer>();
    int i = 0;
    public void inorder(TreeNode root){
        if(root == null)
        {
            return ;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    
    
    public BSTIterator(TreeNode root) {
        inorder(root);
        
        
    }
    
    public int next() {
        return res.get(i++);
        
    }
    
    public boolean hasNext() {
        if(i < res.size())
        {
            return true;
        }
        return false;
    }
}
