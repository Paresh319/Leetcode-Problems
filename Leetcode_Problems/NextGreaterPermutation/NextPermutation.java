package Leetcode_Problems.NextGreaterPermutation;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        
        int pos = -1;
        for(int i = nums.length - 1; i > 0 ; i--)
        {
            if(nums[i] > nums[i - 1])
            {
                pos =  i - 1;
                break;
            }
        }
        if(pos >= 0)
        {
            int prev = Integer.MAX_VALUE;
        int pos2 = 0;

        for(int i = pos + 1; i < nums.length; i++)
        {
            if(nums[i] > nums[pos])
            {
                prev = Math.min(prev, nums[i]);
                pos2 = i;

            }
        }

        int temp = nums[pos];
        nums[pos] = nums[pos2];
        nums[pos2] = temp;
            
        }
        
        reverse(nums, pos + 1);
        
        
    }
    
     private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
