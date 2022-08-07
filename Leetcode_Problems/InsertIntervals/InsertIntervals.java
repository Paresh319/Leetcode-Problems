package Leetcode_Problems.InsertIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int[] p: intervals)
        {
            res.add(p);
        }
        res.add(newInterval);

        Collections.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return b[0] - a[0];
            }
        });
        pq.add(res.get(0));

        for(int i = 1; i < res.size(); i++)
        {
            int[] temp = pq.peek();
            if(res.get(i)[0] <= temp[1])
            {
                int start = pq.peek()[0];
                int end = Math.max(pq.peek()[1], res.get(i)[1]);
                pq.poll();
                pq.add(new int[]{start, end});
                continue;
            }
            pq.add(res.get(i));
        }
        
       int[][] r = new int[pq.size()][2];
       int k = pq.size() - 1;
       while(!pq.isEmpty())
        {
            r[k][0] = pq.peek()[0];
            r[k][1] = pq.peek()[1];
            pq.poll();
           k--;
        }
       
        return r;
    }
    
}
