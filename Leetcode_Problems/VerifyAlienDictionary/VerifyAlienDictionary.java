package Leetcode_Problems.VerifyAlienDictionary;

import java.util.HashMap;

public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hm = new HashMap();
        for(int i = 0; i < order.length(); i++)
        {
            hm.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            int j = 0;
            while(j < word1.length() && j < word2.length())
            {
                if(hm.get(word1.charAt(j)) < hm.get(word2.charAt(j)))
                {
                    return false;
                }
                j++;
            }
        }
        return true;
        
    }
    
}
