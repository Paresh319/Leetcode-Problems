package Leetcode_Problems.SkyLineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b)
            {
                return b[0] - a[0];
            }
        });

        

        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a , int[] b)
            {
                return b[0] - a[0];
            }
            
        });
        pq1.offer(buildings[0]);


        for(int i = 1; i < buildings.length; i++)
        {
            int sPoint = buildings[i][0];
            int pStart = pq1.peek()[0];
            int pEnd = pq1.peek()[1];
            int pHeight = pq1.peek()[2];
            int sHeight = buildings[i][2];

            if(sPoint < pEnd)
            {
                if(sHeight > pHeight)
                {
                    pq1.offer(buildings[i]);
                }
                else if(sHeight < pHeight)
                {
                    pq1.offer(new int[]{pEnd, buildings[i][1], buildings[i][2]});
                }
            }
            else
            {
                pq1.offer(new int[]{pEnd, 0, 0});
                pq1.offer(buildings[i]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        
        while(!pq1.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            int[] t = pq1.poll();
            temp.add(t[0]);
            temp.add(t[2]);
            res.add(temp);
        }
        return res;
    }
    
}
