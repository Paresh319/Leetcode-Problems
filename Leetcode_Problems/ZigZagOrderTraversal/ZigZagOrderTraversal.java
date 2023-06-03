package Leetcode_Problems.ZigZagOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */  class TreeNode {
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
 

public class ZigZagOrderTraversal {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            List<List<Integer>> res= new ArrayList<>();
            boolean flag= true;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    List<Integer> temp = new ArrayList<>();
                    TreeNode d = q.poll();
                    if(flag) {
                        if(d.right != null) {
                            q.offer(d.right);
                        }
                        if(d.left != null) {
                            q.offer(d.left);
                        }
                    }
                    else{
                        if(d.left != null) {
                            q.offer(d.left);
                        }
                        if(d.right != null) {
                            q.offer(d.right);
                        }
                    }
                    res.add(new ArrayList<>(temp));
                }
                flag = !flag;
            }
            return res;
        }
    }
    
}
