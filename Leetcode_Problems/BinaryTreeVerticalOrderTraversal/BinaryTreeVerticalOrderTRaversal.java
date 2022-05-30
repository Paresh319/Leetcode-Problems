package Leetcode_Problems.BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class BinaryTreeVerticalOrderTRaversal {
    HashMap<Integer, List<int[]>> hm ;
    int minColumn = 0, maxColumn = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
         if(root == null)
        {
            return res;
        }
        hm = new HashMap<Integer, List<int[]>>();
        
        levelOrderTraversal(root, 0, 0);
        
        
        for(int i = minColumn; i <= maxColumn; i++)
        {
            Collections.sort(hm.get(i), new Comparator<int[]>() {
                @Override
                public int compare(int[]a ,int[] b)
                {
                    return a[0] - b[0];
                }
                
            });

            List<Integer> sortedColumn = new ArrayList<>();
            for(int[] p: hm.get(i))
            {
                sortedColumn.add(p[1]);
            }
            res.add(sortedColumn);
        }
        return res;
         
    }
    
    public void levelOrderTraversal(TreeNode root, int row, int col)
    {
        if(root == null)
        {
            return;
        }
        if(!hm.containsKey(col))
        {
            List<int[]> temp = new ArrayList<>();
            temp.add(new int[]{row, root.val});
            hm.put(col, temp);
        }
        else
        {
            hm.get(col).add(new int[]{row, root.val});
            
        }
        this.minColumn = Math.min(minColumn, col);
        this.maxColumn = Math.max(maxColumn, col);
        if(root.left != null)
        {
            levelOrderTraversal(root.left, row + 1, col - 1);
        }

        if(root.right != null)
        {
            levelOrderTraversal(root.right, row + 1, col + 1);
        }
    }
}
