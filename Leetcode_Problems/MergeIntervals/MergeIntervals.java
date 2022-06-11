package Leetcode_Problems.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Stack<int[]> s = new Stack<>();
        s.push(intervals[0]);
        int k = 0;

        for(int i = 1; i < intervals.length; i++)
        {
            int[] temp = s.peek();
            if(temp[1] >= intervals[i][0])
            {
                int start = temp[0];
                int end = Math.max(temp[1], intervals[i][1]);
                s.pop();
                s.push(new int[]{start, end});
            }
            else
            {
                s.push(intervals[i]);
            }
        }
        
        int[][] res = new int[s.size()][2];
        
        while(!s.isEmpty())
        {
            res[k] = s.pop();
            k++;
        }
        return res;
        
        
    }
    
}
