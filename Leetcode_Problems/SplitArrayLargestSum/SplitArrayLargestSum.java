package Leetcode_Problems.SplitArrayLargestSum;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayLargestSum {
    List<List<Integer>> l = new ArrayList<>();
    
    public int splitArray(int[] nums, int k) {
        recursiveHelper(nums, k, 0);
    }

    public void recursiveHelper(int[] nums, int k, int start) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[start]);
    }
}

