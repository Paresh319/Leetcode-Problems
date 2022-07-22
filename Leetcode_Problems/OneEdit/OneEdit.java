package Leetcode_Problems.OneEdit;

import java.util.HashMap;

public class OneEdit {
    public boolean isOneEditDistance(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(char c: s.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray())
        {
            if(hm.containsKey(c))
            {
                hm.put(c, hm.get(c) - 1);
            }
        }
         
        int count = 0;
        
        for(char c: hm.keySet())
        {
            if((hm.get(c) == -1) || hm.get(c) == 1)
            {
                count++;
            }
        }
        if(count == 1)
        {
            return true;
        }
        return false;
    }
    
}
