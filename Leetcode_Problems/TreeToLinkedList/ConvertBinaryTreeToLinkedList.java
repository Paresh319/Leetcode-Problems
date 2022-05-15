package Leetcode_Problems.TreeToLinkedList;

import java.util.LinkedList;
import java.util.List;

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
public class ConvertBinaryTreeToLinkedList {

    List<TreeNode> res = new LinkedList<>();
    TreeNode head;
    TreeNode curr;
    public void flatten(TreeNode root) {
        head = new TreeNode();
        res.add(head);
        curr = head;
        
        preorder(root);
        
    }

    public void preorder(TreeNode root)
    {
        
    }

    
}
