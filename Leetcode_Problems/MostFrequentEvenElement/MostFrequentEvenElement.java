package Leetcode_Problems.MostFrequentEvenElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                if(!hm.containsKey(nums[i])) {
                    hm.put(nums[i], 0);
                }
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
        }

        ArrayList<Integer> l = new ArrayList<Integer>(hm.keySet());
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(hm.get(o1) != hm.get(o2)) {
                    return hm.get(o1) - hm.get(o2);
                }
                else {
                    return o1 - o2;
                }
            }
        });
        return l.get(0);

    }
    
}
