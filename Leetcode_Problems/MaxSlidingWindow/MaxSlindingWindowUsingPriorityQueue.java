package Leetcode_Problems.MaxSlidingWindow;

import java.util.PriorityQueue;


/*
 * Using priority queue wil also give TLE The best approach s using a double ended queue
 */

public class MaxSlindingWindowUsingPriorityQueue {
    
    /** 
     * @param nums
     * @param k
     * @return int[]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) ->  b - a);

        // int i = 0 ; 
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;

        for(int i = 0; i < k; i++)
        {
            pq.add(nums[i]);
        }
        
        for(int i = k ; i < n; i++)
        {
            res[j] = pq.peek();
            pq.remove(nums[j]);
            pq.add(nums[i]);
            j++;
            
        }
        res[res.length - 1] = pq.peek();
        return res;

    }

    
}
