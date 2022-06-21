package Leetcode_Problems.CountCompleteTreeNodes;

import java.util.LinkedList;
import java.util.Queue;

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
 

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        
        if(root == null)
        {
            return 0;
        }
       Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int count = 1;


        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-- > 0)
            {
                TreeNode d = q.poll();
                if(d.left!=null)
                {
                    q.offer(d.left);
                    count++;
                }
                if(d.right!=null)
                {
                    q.offer(d.right);
                    count++;
                }
            }
        }

        return count;
        
        
    }

    
}
