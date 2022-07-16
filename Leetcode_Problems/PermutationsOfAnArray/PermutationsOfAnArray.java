package Leetcode_Problems.PermutationsOfAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfAnArray {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        permute(nums, 0, n);
        return res;
        
        
    }
    public void permute(int[] nums, int left, int right)
    {
        if(left == n)
        {
             List<Integer> temp = new ArrayList<>();
            for(int p: nums)
            {
                temp.add(p);
            }
            if(!res.contains(temp))
            {
                res.add(new ArrayList<Integer>(temp));
            }
            
        }
        for(int i = left; i < n; i++)
        {
            nums = swap(nums, left, i);
            
            permute(nums, left + 1, right);
            nums = swap(nums, i, left);
        }
    }
    
    public int[] swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
