package Leetcode_Problems.IntersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hm1 = new HashMap<>();

        for(int p: nums1)
        {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }

        for(int p: nums2)
        {
            hm1.put(p, hm1.getOrDefault(p, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();

        for(int m: hm1.keySet())
        {
            if(hm.containsKey(m))
            {
                int min = Math.min(hm.get(m), hm1.get(m));
                for(int i = 0; i < min; i++)
                {
                    l.add(m);
                }
            }
        }
        int[] res = new int[l.size()];
        for(int i = 0; i < l.size();i++)
        {
            res[i] = l.get(i);
        }
        return res;
        
    }
    
}
