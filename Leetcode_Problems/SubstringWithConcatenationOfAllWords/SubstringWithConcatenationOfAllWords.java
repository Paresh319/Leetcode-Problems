package Leetcode_Problems.SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(String word: words)
        {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();

        int n = words[0].length() * words.length;

        for(int i = 0; i < s.length();)
        {
            if(hm.containsKey(s.substring(i, i+3)))
            {
                String temp = s.substring(i, n+1);
                HashMap<String, Integer> t1= new HashMap<>();
                for(int k = 0; k < temp.length(); k+=3)
                {
                    t1.put(s.substring(k, k+3), hm.getOrDefault(s.substring(k, k+3), 0) + 1);
                }
                if(hm.equals(t1))
                {
                    res.add(i);
                    i += n;
                }
            }
            else
            {
                i++;
            }


        }
        return res;
        
        
        
    }
    
}
