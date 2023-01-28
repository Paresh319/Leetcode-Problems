package Leetcode_Problems.RandomGenerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int sum = 0;
    Random rand = new Random();
    
    public boolean insert(int val) {
        if(!hm.containsKey(val)) {
            hm.put(val, val);
            sum += val;
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val)) {
            hm.remove(val);
            sum -= val;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        ArrayList<Integer> list = new ArrayList<Integer>(hm.keySet());
        return list.get(rand.nextInt(list.size()));
    }
}