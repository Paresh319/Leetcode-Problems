package Leetcode_Problems.LongestSubStringWithAtmostKDistinctCharacters;

import java.util.HashMap;

public class LongestSubstringWithKCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        int res = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j < s.length())
        {
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            while(hm.size() > k)
            {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                if(hm.get(s.charAt(i)) == 0)
                {
                    hm.remove(s.charAt(i));
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
        
        
    }
    
}
