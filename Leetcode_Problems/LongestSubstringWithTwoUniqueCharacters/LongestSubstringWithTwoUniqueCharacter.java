package Leetcode_Problems.LongestSubstringWithTwoUniqueCharacters;

import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int i = 0; 
        int j = 0;
        int count = 0;
        int maxLen = 0;
        while(j < s.length())
        {
            hm.put(s.charAt(j), j);
            if(hm.size() == 3)
            {
                int del = Collections.min(hm.values());
                hm.remove(s.charAt(del));
                i = del + 1;
            }
            j++;
            maxLen = Math.max(maxLen, j - i);
            
        }
        return maxLen;
    }
}
