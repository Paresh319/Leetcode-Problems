package Leetcode_Problems.DisjointIntervals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class DisjointIntervals {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashSet<Integer> hs = new HashSet<>();

    public DisjointIntervals() {
        
    }
    
    public void addNum(int value) {
        if(!hs.contains(value)){
            pq.add(value);
            hs.add(value);
        }
    }
    
    public int[][] getIntervals() {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(pq);
        ArrayList<int[]> res = new ArrayList<>();
        while(!pq1.isEmpty()) {
            int temp = pq1.poll();
            int[] t = new int[2];
            t[0] = temp;
            while(!pq1.isEmpty() && pq1.peek() == temp + 1) {
                temp = pq1.poll();
            }
            t[1] = temp;
            res.add(t);
        }

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */