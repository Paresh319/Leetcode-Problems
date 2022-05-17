package Leetcode_Problems.BoundaryOfABinaryTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

public class BoundaryOfAbinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        if(root.left != null || root.right != null)
        {
            findAllLeftNodes(res, root.left);
            findAllLeafNodes(res, root);
            List<Integer> temp = new ArrayList<>();
            findAllRightNodes(temp, root.right);
            Collections.reverse(temp);
            for(int p: temp)
            {
                res.add(p);
            }
            
        }
        
        return res;
    }

    public void findAllLeftNodes(List<Integer> res, TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        if(!isLeaf(root))
        {
            res.add(root.val);
        }
         if(root.left != null)
            findAllLeftNodes(res, root.left);
        else
            findAllLeftNodes(res, root.right);
        // findAllLeftNodes(res, root.left);
    }
    public void findAllLeafNodes(List<Integer> l, TreeNode root)
    {
        if(root.left == null && root.right == null)
        {
            l.add(root.val);
            return;
        }
        if(root.left != null) findAllLeafNodes(l, root.left);
        if(root.right != null) findAllLeafNodes(l, root.right);
    }

    public void findAllRightNodes(List<Integer> l, TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        if(!isLeaf(root))
        {
            l.add(root.val);
        }
         if(root.right != null)
            findAllRightNodes(l,root.right);
        else
            findAllRightNodes(l, root.left);
        

        // findAllRightNodes(l, root.right);
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
