package Leetcode_Problems.ConstructBinaryTreeFromPreAndIn;

import java.util.HashMap;

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
 

public class ConstructBinaryTreeFromInOrderAndPostOrder {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        
        for(int i = 0; i < inorder.length; i++)
        {
            hm.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);

        
        
    }

    public TreeNode arrayToTree(int[] preorder, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);

        root.left = arrayToTree(preorder, start, hm.get(root.val) - 1);
        root.right = arrayToTree(preorder, hm.get(root.val) + 1, end);
        return root;

    }
}
