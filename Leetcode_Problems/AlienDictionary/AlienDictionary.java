package Leetcode_Problems.AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, Boolean> seen = new HashMap<>();
    HashMap<Character, List<Character>> hm;
     StringBuilder sb = new StringBuilder();
    public String alienOrder(String[] words) {
        hm = new HashMap<>();
         for (String word : words) {
            for (char c : word.toCharArray()) {
                hm.putIfAbsent(c, new ArrayList<>());
            }
        }
        for(int i = 0; i < words.length - 1; i++)
        {
            String a = words[i];
            String b = words[i+1];
             if (a.length() > b.length() && a.startsWith(b)) 
             {
                return "";
             }
            
            // int p = 0; int q = 0;
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) 
            {
                if (a.charAt(j) != b.charAt(j)) 
                {
                    hm.get(b.charAt(j)).add(a.charAt(j));
                    break;
                }
            }
        }
         System.out.println(hm);

        for(char c: hm.keySet())
        {
            if(!dfs(c))
            {
                return "";
            }
        }
       if (sb.length() < hm.size())
       {
            return "";
       }
        return sb.toString();
    }
    
   private boolean dfs(Character c) 
   {
        if (seen.containsKey(c)) 
        {
            return seen.get(c); 
        }
        seen.put(c, false);
       
       List<Character> temp = hm.get(c);
       if(temp!= null)
       {
           for (char next : temp) 
           {
            boolean result = dfs(next);
            if (!result) return false;
           }
       }
        
        seen.put(c, true);
        sb.append(c);
        return true;
    }    
}