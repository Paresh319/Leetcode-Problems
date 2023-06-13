package Leetcode_Problems.LeafSimilarTrees;

import java.util.ArrayList;
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
 

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if(l1.equals(l2)) {
            return true;
        }
        return false;
    }
    public void dfs(TreeNode root, ArrayList<Integer> l) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null) {
            l.add(root.val);
        }
        dfs(root.left, l);
        dfs(root.right, l);
    }
}
