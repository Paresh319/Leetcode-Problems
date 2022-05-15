package Leetcode_Problems.ValidTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> hs = new HashSet<>();

        
        HashMap<Integer, List<Integer>> hm  = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            hm.put(i, new ArrayList<Integer>());
        }
        for(int[] edge: edges)
        {
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }

        if(dfs(hm, 0, hs, -1) && hs.size() == n){
            return true;
        }

        return false;
    }
    
   public boolean dfs(HashMap<Integer, List<Integer>> hm, int start, HashSet<Integer> hs, int parent)
   {
       if(hs.contains(start))
       {
           return false;
       }
       hs.add(start);

       for(int a: hm.get(start))
       {
           if(parent != a) // this is important as we need to avoid trivial cycle since we came to that node from the parent but we will encountr that later as we have bi directional graph
           {
               if(!dfs(hm, a, hs, start))
               {
                   return false;
               }
           }
           
       }
       return true;
   }
}
