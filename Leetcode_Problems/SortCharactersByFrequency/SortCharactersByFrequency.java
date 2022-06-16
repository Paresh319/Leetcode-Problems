package Leetcode_Problems.SortCharactersByFrequency;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        for(char c: s.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>(){
            public int compare(Character c1, Character c2)
            {
                return hm.get(c2) - hm.get(c1);
            }
        });
        
        for(char p: hm.keySet())
        {
            pq.offer(p);
        }
        
        String res = "";
        while(!pq.isEmpty())
        {
            char temp = pq.poll();
            int a = hm.get(temp);
            for(int i = 0; i < a; i++)
            {
                res = res + temp;
            }
        }
        
        return res;
        
    }
    
}
