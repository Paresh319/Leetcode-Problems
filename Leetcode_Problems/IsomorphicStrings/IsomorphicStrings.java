package Leetcode_Problems.IsomorphicStrings;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t)
    {
        HashMap<Character, Integer> StoT = new HashMap<Character, Integer>();
        HashMap<Character, Integer> TtoS = new HashMap<Character, Integer>();
        int m = s.length();

        for(int i = 0; i < m; i++)
        {
            StoT.put(s.charAt(i), i);
            TtoS.put(t.charAt(i), i);
        }

        for(int i = 0; i < m; i++){
            int p = StoT.getOrDefault(s.charAt(i), -1);
            int q = TtoS.getOrDefault(t.charAt(i), -1);
            if(p != q)
            {
                return false;
            }
        }
        return true;
    }
    
}
