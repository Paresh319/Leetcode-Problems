package Leetcode_Problems.WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadder2 {
    List<String> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String w: wordList)
        {
            hs.add(w);
        }

        HashMap<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            hm.put(a, new ArrayList<String>());
            char[] arr = a.toCharArray();
            for(int k = 0; k <arr.length; k++)
            {
                char oldChar = arr[k];
                for(char p = 'a'; p <= 'z'; p++)
                {
                    if(p == oldChar)
                    {
                        continue;
                    }
                    arr[k] = p;
                    if(hs.contains(String.valueOf(arr)))
                    {
                        hm.get(a).add(String.valueOf(arr));
                    }
                }
                arr[k] = oldChar;
            }
        }

        
        dfs(hm, res, hs, beginWord, endWord);      
    }

    public void dfs(HashMap<String, List<String>> hm, List<String> res, HashSet<String> hs, 
                    String beginWord, String endWord)
    {
        if(beginWord.equals(endWord))
        {
            res.add(endWord);
            return;
        }
        for(String s: hm.get(beginWord))
        {
            dfs(hm, res, hs, s, endWord);
        }
    }
    


    
}
