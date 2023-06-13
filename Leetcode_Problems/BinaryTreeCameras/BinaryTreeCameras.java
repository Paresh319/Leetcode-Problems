package Leetcode_Problems.BinaryTreeCameras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import Leetcode_Problems.TreeNode;

public class BinaryTreeCameras {
    HashSet<TreeNode> hs = new HashSet();
    int ret = 0;
    public int minCameraCover(TreeNode root) {
        hs.add(null);
        dfs(root, null);
        return ret;
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if(root == null) {
            return;
        }
        dfs(root.left, root);
        dfs(root.right, root);
        if(parent == null && !hs.contains(root) || !hs.contains(root.left) || !hs.contains(root.right)) {
            ret++;
            hs.add(root);
            hs.add(parent);
            hs.add(root.left);
            hs.add(root.right);
        }
    }
}

