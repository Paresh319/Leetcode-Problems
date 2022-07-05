package Leetcode_Problems.LRUCache;

import java.util.ArrayDeque;
import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Integer> hm = new HashMap<>();
    ArrayDeque<Integer> q = new ArrayDeque<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key))
        {
            q.remove(key);
            q.addLast(key);
            return hm.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
        {
            q.remove(key);
            q.addLast(key);
            hm.put(key, value);
        }
        else
        {
            q.addLast(key);
            hm.put(key, value);
        }
        if(hm.size() > capacity)
        {
            int evictionKey = q.getFirst();
            hm.remove(evictionKey);
            q.removeFirst();
        }
        
    }
    
}
