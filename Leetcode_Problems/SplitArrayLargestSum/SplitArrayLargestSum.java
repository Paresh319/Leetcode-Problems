package Leetcode_Problems.SplitArrayLargestSum;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayLargestSum {
    int minSum = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int k) {
        for(int i = 0; i < nums.length - k; i++) {
            recursiveHelper(nums, k, i);
        }
        return minSum;
    }

    public void recursiveHelper(int[] nums, int k, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += nums[i];
        }
        for(int i = start + 1; i < nums.length; i++) {
            recursiveHelper(nums, k, start, end);
        }
    }
}

