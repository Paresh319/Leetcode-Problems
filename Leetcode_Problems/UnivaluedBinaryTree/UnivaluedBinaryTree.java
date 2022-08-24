package Leetcode_Problems.UnivaluedBinaryTree;

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

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        return dfs(root, value);
        
    }
    


    public boolean dfs(TreeNode root, int value)
    {
        if(root == null)
        {
            return true;
        }
        if(root.val != value){
            return false;
        }
        
        return dfs(root.left, value) && dfs(root.right, value);
    }
}
