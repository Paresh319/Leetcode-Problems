package Leetcode_Problems.FlattenBinaryTreeToLinkedList;

import java.util.LinkedList;
// import java.util.List;

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


class Node
{
    TreeNode node;
}
class LList{
    Node node;
    Node next;

}
public class ConvertBinaryTreeToLinkedList {

    LinkedList<TreeNode> res = new LinkedList<TreeNode>();
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
        TreeNode node = new TreeNode(root.val);
        
        
    }

    
}
