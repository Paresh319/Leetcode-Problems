package Leetcode_Problems.LeaastNumberOfUniqueIntegerAfterKRemovals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> l = new ArrayList<Integer>(hm.keySet());
        Collections.sort(l, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return hm.get(a) - hm.get(b);
            }
        });
        int i = 0;
        while(k > 0) {
            int a = hm.get(l.get(i));
            if(a <= k) {
                k = k - a;
                hm.remove(l.get(i));
            }
            else {
                k = 0;
            }
            i++;
        }
        return hm.size();
    }
}