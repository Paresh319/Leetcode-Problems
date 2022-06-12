package Leetcode_Problems.MaxSlidingWindow;

import java.util.ArrayDeque;
/*
 * most eficient solution for sliding window maximum 
 * come back to this and revise as it is confusing.
 
 Using monotonically decreasing queue
 */
public class MAximumSlidingWindowUsingDeque {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        ArrayDeque<Integer> aq = new ArrayDeque<>();
        int ri = 0;
        int[] output = new int[n- k + 1];
        for (int i = 0; i < n; i++) {

            if(!aq.isEmpty() && aq.getFirst() < i - k + 1)
            {
                aq.removeFirst();
            }

            while(!aq.isEmpty() && nums[aq.getLast()] < nums[i])
            {
                aq.removeLast();
            }
            aq.addLast(i);

            if(i >= k - 1)
            {
                output[ri++] = nums[aq.getFirst()];
            }
            
        }
        return output;
    }

    
}
