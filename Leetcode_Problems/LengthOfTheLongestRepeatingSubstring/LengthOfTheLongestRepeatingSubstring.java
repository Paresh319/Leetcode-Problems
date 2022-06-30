package Leetcode_Problems.LengthOfTheLongestRepeatingSubstring;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LengthOfTheLongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++) 
            {
                hm.put(s.substring(i, j), hm.getOrDefault(s.substring(i,j), 0) + 1);
            }
        }

        List<String> l = (List) hm.keySet();
        Collections.sort(l, new Comparator<String>() {
            public int compare(String a, String b)
            {
                return a.length() - b.length();
            }
            
        });

        int p = l.get(0).length();
        return p;

        
    }
    
}
