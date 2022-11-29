package Leetcode_Problems.NoDirectReports;

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

public class NoDirectReports {

    static HashMap<TreeNode, Integer> exclude = new HashMap<TreeNode, Integer>();
    static HashMap<TreeNode, Integer> visited = new HashMap<TreeNode, Integer>();
    public static int maxReports(TreeNode root, boolean includeFlag) {
        if(root.left == null && root.right == null) {
            if(includeFlag) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(visited.containsKey(root)) {
            return visited.get(root);
        }

        int incRoot = maxReports(root.left, false) + maxReports(root.right, false) + 1;
        int excRoot = Math.max(maxReports(root.left, true), maxReports(root.left, false)) 
                        + Math.max(maxReports(root.right, true), maxReports(root.right, false));
        visited.put(root, Math.max(incRoot, excRoot));
        return Math.max(incRoot, excRoot);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(maxReports(root, false));
    }
    
}
