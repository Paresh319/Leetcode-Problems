package Leetcode_Problems.ShortestDistanceBetweenWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestDistanceBetweenWords {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i < wordsDict.length; i++)
        {
            if(!hm.containsKey(wordsDict[i]))
            {
                hm.put(wordsDict[i], new ArrayList<Integer>());
            }
            hm.get(wordsDict[i]).add(i);
        }

        ArrayList<Integer> l1 = hm.get(word1);
        ArrayList<Integer> l2 = hm.get(word2);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l1.size(); i++)
        {
            for(int j = 0; j < l2.size(); j++)
            {
                min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
            }
        }
        return min;
        

        
    }
    
}
