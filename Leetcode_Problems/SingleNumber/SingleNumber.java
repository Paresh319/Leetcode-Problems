package Leetcode_Problems.SingleNumber;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            xor = xor ^ nums[i];
        }
        return xor;
    }
    
}
