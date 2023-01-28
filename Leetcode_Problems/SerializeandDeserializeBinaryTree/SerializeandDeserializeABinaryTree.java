package Leetcode_Problems.SerializeandDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeandDeserializeABinaryTree {
    // Encodes a tree to a single string.
    String s;
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        String ret = rSerialize(root, "");
        System.out.print(ret);
        return ret.substring(0, ret.length() - 1);
        
    }

    public String rSerialize(TreeNode root, String s) {
        if(root == null) {
            s += "null,";   
        }
        else {
            s += String.valueOf(root.val) + ",";
            s = rSerialize(root.left, s);
            s = rSerialize(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) {
            return null;
        }

        ArrayList<String> l = new ArrayList<>();
        String[] temp = data.split(",");
        
        for(String c: temp) {
            l.add(c);
        }
        TreeNode head = rDeserialize(l);
        return head;
    }
    

    public TreeNode rDeserialize(List<String> l) {
        if(l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rDeserialize(l);
        root.right = rDeserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));