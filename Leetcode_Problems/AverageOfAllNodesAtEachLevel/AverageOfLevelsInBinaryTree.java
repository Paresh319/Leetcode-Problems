package Leetcode_Problems.AverageOfAllNodesAtEachLevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        List<Double> res = new ArrayList<>();
        int prev = 0;

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;

            for(int i = 0; i < size; i++)
            {
                TreeNode a = q.poll();
                sum += a.val;
                if(a.left != null){
                    q.offer(a.left);
                }
                if(a.right != null){
                    q.offer(a.right);
                }
            }
            res.add((double)sum/size);
        }
        return res;
        
    }
    
}
