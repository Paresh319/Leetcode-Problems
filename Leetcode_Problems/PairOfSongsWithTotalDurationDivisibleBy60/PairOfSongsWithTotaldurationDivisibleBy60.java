package Leetcode_Problems.PairOfSongsWithTotalDurationDivisibleBy60;

import java.util.HashMap;

public class PairOfSongsWithTotaldurationDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for(int n : time) {
            if(n % 60 == 0) {
                count += hm.getOrDefault(0,0);
            }
            else {
                if(hm.containsKey(60 - (n % 60))) {
                    count += hm.get(60 - n % 60);
                }
            }
            hm.put(n % 60, hm.getOrDefault(n % 60, 0) + 1);
        }
        return count;
    }
}
