package Leetcode_Problems.IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int k = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int p: nums1)
        {
            hm.put(p, 1);
        }
        
        for(int p: nums2)
        {
            if(hm.containsKey(p))
            {
                hm.put(p, hm.get(p) + 1);
            }
        }
        List<Integer> l = new ArrayList<>();

        for(int m: hm.keySet())
        {
            if(hm.get(m) > 1)
            {
                l.add(m);
            }
        }
        k = l.size();
        int[] result = new int[k];
        int a = 0;
        for(int p: l)
        {
            result[a++] = p;
        }
        return result;

    }
    
}
