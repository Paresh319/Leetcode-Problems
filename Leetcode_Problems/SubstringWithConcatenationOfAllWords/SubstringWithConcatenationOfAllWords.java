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
        int sizeOfEachWord = words[0].length();

        for(int i = 0; i <= s.length() - n; i++)
        {
                String temp = s.substring(i, i + n);
                HashMap<String, Integer> t1= new HashMap<>();
                for(int k = 0; k <= temp.length() - sizeOfEachWord; k += sizeOfEachWord )
                {
                    t1.put(temp.substring(k, k+sizeOfEachWord), t1.getOrDefault(temp.substring(k, k+sizeOfEachWord), 0) + 1);
                }
                if(hm.equals(t1))
                {
                    res.add(i);
                }
        }
        return res;
    }
    
}
