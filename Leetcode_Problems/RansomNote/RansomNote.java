package Leetcode_Problems.RansomNote;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        
        for(char c: ransomNote.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        for(char c: magazine.toCharArray()){
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }
        
        for(char m: hm.keySet()){
            if(!hm1.containsKey(m) || (hm1.get(m) < hm.get(m))){
                return false;
            }
        }
        return true;
    }
    
}
