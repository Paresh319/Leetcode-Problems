package Leetcode_Problems.RomanToInteger;

import java.util.HashMap;

public class RomantoInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);

        int ans = 0;
        int i = 0;

        while(i < s.length())
        {
            if(i < s.length() - 1)
            {
                String twoSymbols = s.substring(i, i+2);
                if(values.containsKey(twoSymbols))
                {
                    ans += values.get(twoSymbols);
                    i+= 2;
                    continue;
                }
                
            }
            

            String oneSymbol = s.substring(i, i+1);
            
                ans += values.get(oneSymbol);
            
            i++;

        
        
    }
        return ans;
    }
    
}
