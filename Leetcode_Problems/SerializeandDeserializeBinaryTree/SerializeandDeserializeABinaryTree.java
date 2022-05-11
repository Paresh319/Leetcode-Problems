package Leetcode_Problems.SerializeandDeserializeBinaryTree;

import java.util.Arrays;
import java.util.List;

import javax.naming.ldap.Rdn;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

public class SerializeandDeserializeABinaryTree {
    public String rSerialize(TreeNode root, String s)
    {
        if(root == null)
        {
            s += "null,";
        }
        s += String.valueOf(root.val) + "," ;
        s =  rSerialize(root.left, s);
        s = rSerialize(root.right, s);
        return s;
    }

    public String serialize(TreeNode root) {
       return  rSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] l = data.split(",");
        List<String> res = Arrays.asList(l);
        return rDeserialize(res);

        
    }

    public TreeNode rDeserialize(List<String> l)
    {
        if(l.get(0) == null)
        {
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
