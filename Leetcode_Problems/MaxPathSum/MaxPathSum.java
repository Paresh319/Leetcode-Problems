package Leetcode_Problems.MaxPathSum;

import java.util.ArrayList;
import java.util.HashMap;
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

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, ArrayList<TreeNode>> hm = new HashMap<>();
        dfs(root, hm);

        System.out.println(hm);
        return 1;
    }

    public void dfs(TreeNode root, HashMap<TreeNode, ArrayList<TreeNode>> hm) {
       if(root == null) {
          return;
       }

       hm.putIfAbsent(root, new ArrayList<TreeNode>());
       if(root.left!= null) {
        hm.get(root).add(root.left);
        hm.putIfAbsent(root.left, new ArrayList<TreeNode>());
        hm.get(root.left).add(root);
      }

      if(root.right != null){
        hm.get(root).add(root.right);
        hm.putIfAbsent(root.right, new ArrayList<>());
        hm.get(root.right).add(root);
      }
      dfs(root.left, hm);
      dfs(root.right, hm);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        MaxPathSum m = new MaxPathSum();
        System.out.println(m.maxPathSum(root));
    }
}
