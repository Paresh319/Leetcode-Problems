package Leetcode_Problems.FindAllANagramsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnaGramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        char[] tmp = p.toCharArray();
        Arrays.sort(tmp);
        String t = String.valueOf(tmp);
        // String cmp = t;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length() - n; i+=n)
        {
            char[] o = s.substring(i, i+n).toCharArray();
            Arrays.sort(o);
            String l = String.valueOf(o);
            if(l.equals(t))
            {
                res.add(i);
            }
        }
        return res;
        
    }
    
}
