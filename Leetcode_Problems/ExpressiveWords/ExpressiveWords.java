package Leetcode_Problems.ExpressiveWords;

import java.util.HashMap;
import java.util.Map;

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> temp;
        int count = 0;

        
        for(String p: words)
        {
            temp = new HashMap<>();
            boolean flag = false;
            for(char c: p.toCharArray())
            {
                if(!hm.containsKey(c))
                {
                    flag = true;
                    break;
                }

                temp.put(c, hm.getOrDefault(c, 0) + 1);
            }
            if(flag || temp.size() != hm.size())
            {
                continue;
            }
            boolean flag2 = true;
            for(Map.Entry<Character, Integer> m: hm.entrySet())
            {
                int a = m.getValue();
                int b = temp.get(m.getKey());
                if(a != b && b - a < 3)
                { 
                    flag2 = false;
                    break;
                }
            }

            if(flag2)
            {
                count++;
            }
        }
        return count;
    }
    
}
