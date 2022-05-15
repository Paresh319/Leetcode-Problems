package Leetcode_Problems.MergeSortedArray;

import java.util.PriorityQueue;

public class MergeSortedArrays {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int j = 0;

        while(i < m || j < n)
        {
            if(i < m)
            {
                pq.add(nums1[i]);
                i++;
            }
            if(j < n)
            {
                pq.add(nums2[j++]);
            }

        }
        int[] res = new int[m + n];
        int k = 0;
        while(!pq.isEmpty())
        {
            res[k++] = pq.poll();
        }
        return res;
        
    }
    
}
