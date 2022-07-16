package Leetcode_Problems.MAjorityElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int val = Math.floorDiv(n, 3);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int m: hm.keySet())
        {
            if(hm.get(m) == val)
            {
                res.add(m);
            }
        }
        return res;
        
        
        
    }
    
}
