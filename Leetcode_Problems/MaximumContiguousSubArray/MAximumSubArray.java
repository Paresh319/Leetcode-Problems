package Leetcode_Problems.MaximumContiguousSubArray;

public class MAximumSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] max = new int[n]; 
        max[0] = nums[0];
        
        for(int i = 1; i < n; i++)
        {
            if(max[i-1] + nums[i] > nums[i])
            {
                max[i] = max[i-1] + nums[i];
            }
            else
            {
                max[i] = nums[i];
            }
        }
       
        int a = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            a = Math.max(a, max[i]);
        }
        return a;
    }
}
