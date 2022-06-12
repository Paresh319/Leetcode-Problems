package Leetcode_Problems.MaxSlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class MaximumSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < nums.length - k + 1; i++)
        {
            int max = getMax(i, i+ k - 1, nums);
            l.add(max);
        }
        int[] res = new int[l.size()];
        int j = 0;
        for(int a: l)
        {
            res[j] = a;
            j++;
        }
        return res;
    }
    
    public int getMax(int start, int end, int[] nums)
    {
        System.out.println(start);
        int maxValue = nums[start];
        for(int i = start + 1; i <= Math.min(nums.length - 1, end); i++)
        {
            maxValue = Math.max(maxValue, nums[i]);

        }
        return maxValue;
    }
    
}
