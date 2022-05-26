package Leetcode_Problems.OnlineMajorityElementInSubarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OnlineMajorityElementInSubarray
{
    ArrayList<Integer> a = new ArrayList<>();
    public OnlineMajorityElementInSubarray(int[] arr) {
        for(int i  = 0; i < arr.length; i++)
        {
            a.add(arr[i]);
        }
        
    }
    
    public int query(int left, int right, int threshold) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = left; i <= right; i++)
        {
            hm.put(a.get(i), hm.getOrDefault(a.get(i), 0) + 1);
        }
        Set<Integer> hs = hm.keySet();

        Iterator<Integer> namesIterator = hs.iterator();
        while(namesIterator.hasNext())
        {
            if(hm.get(namesIterator.next()) >= threshold)
            {
                return namesIterator.next();
            }
        }

        return -1;

        
        
    }

}