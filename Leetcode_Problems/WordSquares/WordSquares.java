package Leetcode_Problems.WordSquares;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSquares {
    List<List<String>> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    public List<List<String>> wordSquares(String[] words) {
        // k = words[0].length();
        for(int i = 0; i < words.length; i++)
        {
            int len = words[i].length();
            ArrayList<String> l = new ArrayList<String>();
            // l.add(words[i]);

            backtrack(words, i, len, l, 0, new HashSet<String>());
        }
        return res;
    }
    public void backtrack(String[] words, int i, int len, ArrayList<String> l, int ind, HashSet<String> hs)
    {
        if(l.size() == len)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        hs.add(words[i]);

        for(int k = 0; k < words.length; k++)
        {
            String str = words[k];
            if(!str.equals(words[i]) && !hs.contains(str))
            {
                if(str.length() == words[i].length())
                {
                    if(words[i].charAt(ind + 1) == str.charAt(ind))
                    {
                        backtrack(words, len, k, l, ind + 1, hs);
                    }
                }
            }
        }
    }
}