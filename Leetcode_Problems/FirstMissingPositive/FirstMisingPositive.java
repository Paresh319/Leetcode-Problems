package Leetcode_Problems.FirstMissingPositive;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstMisingPositive {

    public int firstMissingPositive(int[] nums) {
        int contains = 0;
        for(int a: nums)
        {
            if(a == 1)
            {
                contains++;
                break;
            }
        }
        if(contains == 0)
        {
            return 1;
        }
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 || nums[i] < 0 || nums[i] > n)
            {
                nums[i] = 1; 
            }
        }
        
        for(int i = 0;i < n; i++)
        {
            int a = Math.abs(nums[i]);
            if(a == n)
            {
                nums[0] = -Math.abs(nums[0]);
                continue;
            }
            
            nums[a] = -Math.abs(nums[a]);
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }
        
        if (nums[0] > 0)
            return n;
        return n + 1;   
    }

    
}
