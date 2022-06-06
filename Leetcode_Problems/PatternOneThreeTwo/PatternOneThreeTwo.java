package Leetcode_Problems.PatternOneThreeTwo;

import java.util.Stack;

public class PatternOneThreeTwo {

    //brute force solution  O(n^3)
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int[] res = new int[]{nums[i], nums[k], nums[j]};
                    if(patternMatches(res))
                    {
                        return true;
                    }

                    
                }
                
            }
            
        }
        return false;
        
    }

    public boolean patternMatches(int[] temp)
    {
        if(temp[0] > temp[1] || temp[1] > temp[2] || temp[0] > temp[2])
        {
            return false;
        }
        return true;

    }

    //Monotonic stack solution O(n)
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < min.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
            
        }
        Stack<Integer> stk = new Stack<>();

        for(int j = n-1; j >=0; j--)
        {
            if(nums[j] > min[j])
            {
                while(!stk.isEmpty() && stk.peek() <= min[j])
                {
                    stk.pop();
                }
                if(!stk.isEmpty() && stk.peek() < nums[j])
                {
                    return true;
                }
                stk.push(nums[j]);
            }
        }
        return false;

        
    }

    
}
