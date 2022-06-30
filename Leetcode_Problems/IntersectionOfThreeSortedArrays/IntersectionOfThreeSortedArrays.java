package Leetcode_Problems.IntersectionOfThreeSortedArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        for(int i = 0; i < arr1.length;i++)
        {
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }

        for(int i = 0; i < arr2.length;i++)
        {
            hm.put(arr2[i], hm.getOrDefault(arr2[i], 0) + 1);
        }

        for(int i = 0; i < arr3.length;i++)
        {
            hm.put(arr3[i], hm.getOrDefault(arr3[i], 0) + 1);
        }
        List<Integer> l = new ArrayList<>();

        for(int m: hm.keySet())
        {
            if(hm.get(m) == 3)
            {
                l.add(m);
            }
        }
        return l;
        
        
    }
    
}
