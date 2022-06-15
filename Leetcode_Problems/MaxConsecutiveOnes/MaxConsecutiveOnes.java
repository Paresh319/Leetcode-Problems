package Leetcode_Problems.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int maxLen = Integer.MIN_VALUE;
        while(end < nums.length)
        {
            if(nums[end] == 0)
            {
                count++;
            }
            while(count > k)
            {
                if(nums[start] == 0)
                {
                    count--;
                    
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;

    }
}
