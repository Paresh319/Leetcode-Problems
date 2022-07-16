package Leetcode_Problems.PermutationsOfAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfAnArray {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length);
        return res;
    }
    
    public void permute(int[] nums, int left, int right)
    {
        for(int i = left; i <= right; i++)
        {
            nums = swap(nums, left, i);
            List<Integer> temp = new ArrayList<>();
            for(int p: nums)
            {
                temp.add(p);
            }
            if(!res.contains(temp))
            {
                res.add(new ArrayList<Integer>(temp));
            }
            permute(nums, i + 1, nums.length - 1);
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
