package Leetcode_Problems.TopKFrequentWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s: words)
        {
            if(hm.containsKey(s))
            {
                int f = hm.get(s) + 1;
                hm.put(s, f);
            }
            else
            {
                hm.put(s, 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(k, (a, b) -> 
        hm.get(a) == hm.get(b)? b.compareTo(a): hm.get(a) - hm.get(b));

        for(String s: hm.keySet())
        {
            pq.offer(s);
            if(pq.size() > k)
            {
                pq.poll();
            } 
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty())
        {
            res.add(0,pq.poll());
        }
        return res;
    }
}
