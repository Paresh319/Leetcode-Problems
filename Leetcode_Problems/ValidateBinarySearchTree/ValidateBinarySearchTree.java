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
class Solution {
    List<Integer> s = new ArrayList<Integer>();
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        
        if(flag == false)
        {
            return false;
        }
        List<Integer> k = new ArrayList<>(s);
        Collections.sort(s);
        if(s.equals(k))
        {
            return true;
        }
        return false;
        
    }
    
    public void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        helper(root.left);
        if(s.contains(root.val))
        {
            flag  = false;
        }
        s.add(root.val);
        helper(root.right);
       
    }
}
