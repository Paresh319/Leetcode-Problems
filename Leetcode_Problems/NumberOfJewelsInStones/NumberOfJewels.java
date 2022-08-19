package Leetcode_Problems.NumberOfJewelsInStones;

import java.util.HashSet;

public class NumberOfJewels {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hs = new HashSet();
        for(char c: jewels.toCharArray())
        {
            hs.add(c);
        }
        
        int count = 0;
        for(char c: stones.toCharArray())
        {
            if(hs.contains(c))
            {
                count++;
            }
        }
        return count;
        
    }
    
}
