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
    public List<List<Integer>> levelOrder(TreeNode root) { List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root == null)
        {
            return res;
        }
        bfs(root);
        
        return res;
    }
    public void bfs(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            
            while(size > 0)
            {
                TreeNode l = q.remove();
                System.out.println(l.val);
                temp.add(l.val);
                if(level % 2 == 1)
                {
                    if(l.left != null) q.add(l.left);
                    if(l.right != null) q.add(l.right);
                }
                
                if(level % 2 == 0)
                {
                    if(l.right != null) 
                    {
                        q.add(l.right);
                    }
                    
                    if(l.left != null) 
                    {
                        q.add(l.left);
                    }
                }
                level++;
                size--;
            }
            res.add(new ArrayList<Integer>(temp));  
        }
    }
                                                         }
    
