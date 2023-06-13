package Leetcode_Problems.CountNumberOfGoodNodes;

import Leetcode_Problems.TreeNode;

public class CountNumberOfGoodNodesInATree {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    public void dfs(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
        if(max <= root.val) {
            count++;
        }
    }
}
