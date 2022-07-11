package Leetcode_Problems.MinimumWindowSubstring;

import java.util.HashMap;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: t.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        int i = 0, j = 0;
        int counter = 0;
        int minLength = s.length() + 1;
        int minLeft = 0;
        
        while(j < s.length())
        {
            char c = s.charAt(j);
            if(hm.containsKey(c))
            {
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) >= 0)
                {
                    counter++;
                }
            }
            while(counter == t.length())
            {
                if(j - i + 1 < minLength)
                {
                    minLeft = i;
                    minLength = j - i + 1;
                }
                if(hm.containsKey(s.charAt(i)))
                {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                    if(hm.get(s.charAt(i)) > 0)
                    {
                        counter--;
                    }
                }
                i++;
            }
            j++;
        }
        if(minLength > s.length())
        {
            return "";
        }
        return s.substring(minLeft, minLeft + minLength);
    }
    
}
