package Leetcode_Problems.UniqueNumberOfOccurences;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int a: arr) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int m: hm.keySet()) {
            if(hs.contains(hm.get(m))) {
                return false;
            }
            hs.add(hm.get(m));
        }
        return true;
    }
}
