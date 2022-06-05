package Leetcode_Problems.MissingRangesGoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList();
        if(nums.length == 0)
        {
            String a = String.valueOf(lower);
            String b  = String.valueOf(upper);
             if(a.equals(b))
                {
                    res.add(a);
                    
                }
            else
            {
                res.add(a + "->" + b);
            }
            return res;
        }
        
        if(nums[0] > lower)
        {
            String a = String.valueOf(lower);
            String b  = String.valueOf(nums[0] - 1);
             if(a.equals(b))
                {
                    res.add(a);
                    
                }
            else
            {
                res.add(a + "->" + b);
            }
        }
        
        for(int i = 0 ; i < nums.length - 1; i++)
        {
            if(nums[i + 1] - nums[i] > 1)
            {
                String a = String.valueOf(nums[i] + 1);
                String b  = String.valueOf(nums[i+1] - 1);
                if(a.equals(b))
                {
                    res.add(a);
                    continue;
                }

                res.add(a + "->" + b);
            }
        }
        
        if(upper - nums[nums.length - 1] > 0)
        {
            String a = String.valueOf(nums[nums.length - 1] + 1);
                String b  = String.valueOf(upper);
            if(a.equals(b))
                {
                    res.add(a);
                   
                }
            else
            {
                res.add(a + "->" + b);
            }
            
        }

        
        
        
        return res;
        
        
       
        
    }

    
}
