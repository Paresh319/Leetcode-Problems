package Leetcode_Problems.AllPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 /*
 This is a hard problem basically we need to recursively form a tree starting from 1 to n as root
 so for 0 the left tree would be 1 and right subtree would be n-1 and so on.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode() {  }
}
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
         List<TreeNode> l = new ArrayList<>();
       if(n == 1)
        {

            l.add(new TreeNode());
        }
        else if(n%2 == 1)
        {
            for(int i = 0; i < n; i++)
            {
                int j = n-1 - i;
                List<TreeNode> lNode = allPossibleFBT(i);
                List<TreeNode>  rNode = allPossibleFBT(j);
                for(TreeNode a : lNode)
                {
                    for(TreeNode b : rNode)
                    {
                        TreeNode root = new TreeNode();
                        root.left = a;
                        root.right = b;
                        l.add(root);
                    }
                }
            }
        }
        return l;
    }
    

}
